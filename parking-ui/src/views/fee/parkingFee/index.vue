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

      <el-form-item label="车牌号" prop="licensePlateNumber">
        <el-input
          v-model="queryParams.licensePlateNumber"
          placeholder="请输入车牌号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>





      <el-form-item label="用户账号" prop="userAccount">
        <el-input
          v-model="queryParams.userAccount"
          placeholder="请输入用户账号"
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
          v-hasPermi="['system:fee:add']"
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
          v-hasPermi="['system:fee:edit']"
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
          v-hasPermi="['system:fee:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:fee:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="feeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="停车缴费ID" align="center" prop="parkingFeeId" />
      <el-table-column label="车位号" align="center" prop="parkingSpaceNumber" />
      <el-table-column label="车位类型" align="center" prop="parkingSpaceType" />
      <el-table-column label="车位地址" align="center" prop="parkingSpaceAddress" />
      <el-table-column label="每小时停车费用" align="center" prop="hourlyParkingFee" />
      <el-table-column label="车牌号" align="center" prop="licensePlateNumber" />
      <el-table-column label="开始时间" align="center" prop="startTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.startTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="结束时间" align="center" prop="endTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.endTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="总时间" align="center" prop="totalTime" />
      <el-table-column label="车牌识别" align="center" prop="licensePlateRecognition" />
      <el-table-column label="会员卡号" align="center" prop="membershipCardNumber" />
      <el-table-column label="会员折扣" align="center" prop="memberDiscount" />
      <el-table-column label="总费用" align="center" prop="totalCost" />
      <el-table-column label="用户账号" align="center" prop="userAccount" />
      <el-table-column label="智能推荐" align="center" prop="recommend" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:fee:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:fee:remove']"
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

    <!-- 添加或修改停车缴费对话框 -->
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
        <el-form-item label="车牌号" prop="licensePlateNumber">
          <el-input v-model="form.licensePlateNumber" placeholder="请输入车牌号" />
        </el-form-item>
        <el-form-item label="开始时间" prop="startTime">
          <el-date-picker clearable size="small"
                          v-model="form.startTime"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="结束时间" prop="endTime">
          <el-date-picker clearable size="small"
                          v-model="form.endTime"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="总时间" prop="totalTime">
          <el-input v-model="form.totalTime" placeholder="请输入总时间" />
        </el-form-item>
        <el-form-item label="车牌识别" prop="licensePlateRecognition">
          <el-input v-model="form.licensePlateRecognition" placeholder="请输入车牌识别" />
        </el-form-item>
        <el-form-item label="会员卡号" prop="membershipCardNumber">
          <el-input v-model="form.membershipCardNumber" placeholder="请输入会员卡号" />
        </el-form-item>
        <el-form-item label="会员折扣" prop="memberDiscount">
          <el-input v-model="form.memberDiscount" placeholder="请输入会员折扣" />
        </el-form-item>
        <el-form-item label="总费用" prop="totalCost">
          <el-input v-model="form.totalCost" placeholder="请输入总费用" />
        </el-form-item>
        <el-form-item label="用户账号" prop="userAccount">
          <el-input v-model="form.userAccount" placeholder="请输入用户账号" />
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
import { listFee, getFee, delFee, addFee, updateFee } from "@/api/fee/parkingFee";

export default {
  name: "Fee",
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
      // 停车缴费表格数据
      feeList: [],
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
        hourlyParkingFee: null,
        licensePlateNumber: null,
        startTime: null,
        endTime: null,
        totalTime: null,
        licensePlateRecognition: null,
        membershipCardNumber: null,
        memberDiscount: null,
        totalCost: null,
        userAccount: null,
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
    /** 查询停车缴费列表 */
    getList() {
      this.loading = true;
      listFee(this.queryParams).then(response => {
        this.feeList = response.rows;
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
        parkingFeeId: null,
        parkingSpaceNumber: null,
        parkingSpaceType: null,
        parkingSpaceAddress: null,
        hourlyParkingFee: null,
        licensePlateNumber: null,
        startTime: null,
        endTime: null,
        totalTime: null,
        licensePlateRecognition: null,
        membershipCardNumber: null,
        memberDiscount: null,
        totalCost: null,
        userAccount: null,
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
      this.ids = selection.map(item => item.parkingFeeId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加停车缴费";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const parkingFeeId = row.parkingFeeId || this.ids
      getFee(parkingFeeId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改停车缴费";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.parkingFeeId != null) {
            updateFee(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addFee(this.form).then(response => {
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
      const parkingFeeIds = row.parkingFeeId || this.ids;
      this.$modal.confirm('是否确认删除停车缴费编号为"' + parkingFeeIds + '"的数据项？').then(function() {
        return delFee(parkingFeeIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/fee/export', {
        ...this.queryParams
      }, `fee_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
