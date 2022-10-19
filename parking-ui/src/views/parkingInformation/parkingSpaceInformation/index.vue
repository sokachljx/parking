<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="车位号" prop="parkingSpaceNumber">
        <el-input
          v-model="queryParams.parkingSpaceNumber"
          placeholder="请输入车位号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="车位地址" prop="parkingSpaceAddress">
        <el-input
          v-model="queryParams.parkingSpaceAddress"
          placeholder="请输入车位地址"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="每小时停车费用" prop="hourlyParkingFee">
        <el-input
          v-model="queryParams.hourlyParkingFee"
          placeholder="请输入每小时停车费用"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="智能推荐" prop="recommend">
        <el-input
          v-model="queryParams.recommend"
          placeholder="请输入智能推荐"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['information:spaceInformation:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['information:spaceInformation:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['information:spaceInformation:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['information:spaceInformation:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="informationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="车位信息ID" align="center" prop="parkingSpaceInformationId" />
      <el-table-column label="车位号" align="center" prop="parkingSpaceNumber" />
      <el-table-column label="车位类型" align="center" prop="parkingSpaceType" />
      <el-table-column label="车位地址" align="center" prop="parkingSpaceAddress" />
      <el-table-column label="车位状态" align="center" prop="parkingSpaceStatus" />
      <el-table-column label="每小时停车费用" align="center" prop="hourlyParkingFee" />
      <el-table-column label="车位备注" align="center" prop="parkingSpaceRemarks" />
      <el-table-column label="智能推荐" align="center" prop="recommend" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['information:spaceInformation:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['information:spaceInformation:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改车位信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="车位号" prop="parkingSpaceNumber">
          <el-input v-model="form.parkingSpaceNumber" placeholder="请输入车位号" />
        </el-form-item>
        <el-form-item label="车位地址" prop="parkingSpaceAddress">
          <el-input v-model="form.parkingSpaceAddress" placeholder="请输入车位地址" />
        </el-form-item>
        <el-form-item label="每小时停车费用" prop="hourlyParkingFee">
          <el-input v-model="form.hourlyParkingFee" placeholder="请输入每小时停车费用" />
        </el-form-item>
        <el-form-item label="车位备注" prop="parkingSpaceRemarks">
          <el-input v-model="form.parkingSpaceRemarks" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="智能推荐" prop="recommend">
          <el-input v-model="form.recommend" placeholder="请输入智能推荐" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listInformation, getInformation, delInformation, addInformation, updateInformation } from "@/api/parkingSpace/space";

export default {
  name: "Information",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 车位信息表格数据
      informationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        parkingSpaceNumber: null,
        parkingSpaceType: null,
        parkingSpaceAddress: null,
        parkingSpaceStatus: null,
        hourlyParkingFee: null,
        parkingSpaceRemarks: null,
        recommend: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        recommend: [
          { required: true, message: "智能推荐不能为空", trigger: "blur" }
        ],
        createTime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ],
        updateTime: [
          { required: true, message: "更新时间不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询车位信息列表 */
    getList() {
      this.loading = true;
      listInformation(this.queryParams).then(response => {
        this.informationList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        parkingSpaceInformationId: null,
        parkingSpaceNumber: null,
        parkingSpaceType: null,
        parkingSpaceAddress: null,
        parkingSpaceStatus: "0",
        hourlyParkingFee: null,
        parkingSpaceRemarks: null,
        recommend: null,
        createTime: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.parkingSpaceInformationId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加车位信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const parkingSpaceInformationId = row.parkingSpaceInformationId || this.ids
      getInformation(parkingSpaceInformationId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改车位信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.parkingSpaceInformationId != null) {
            updateInformation(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addInformation(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const parkingSpaceInformationIds = row.parkingSpaceInformationId || this.ids;
      this.$modal.confirm('是否确认删除车位信息编号为"' + parkingSpaceInformationIds + '"的数据项？').then(function() {
        return delInformation(parkingSpaceInformationIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('information:spaceInformation:export', {
        ...this.queryParams
      }, `information_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
