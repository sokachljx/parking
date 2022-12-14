<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="样品编号" prop="srNo">
        <el-input
            v-model="queryParams.srNo"
            placeholder="请输入样品编号"
            clearable
            size="small"
            @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="样品名称" prop="srName">
        <el-input
            v-model="queryParams.srName"
            placeholder="请输入样品名称"
            clearable
            size="small"
            @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="送样单位" prop="srDeliveryUnit">
        <el-input
            v-model="queryParams.srDeliveryUnit"
            placeholder="请输入送样单位"
            clearable
            size="small"
            @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="送样人员" prop="srUsername">
        <el-input
            v-model="queryParams.srUsername"
            placeholder="请输入送样人员"
            clearable
            size="small"
            @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="送样手机" prop="srPhone">
        <el-input
            v-model="queryParams.srPhone"
            placeholder="请输入送样手机"
            clearable
            size="small"
            @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="送样地址" prop="srAddress">
        <el-input
            v-model="queryParams.srAddress"
            placeholder="请输入送样地址"
            clearable
            size="small"
            @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="样品特征" prop="srFeatures">
        <el-input
            v-model="queryParams.srFeatures"
            placeholder="请输入样品特征"
            clearable
            size="small"
            @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="样品重量" prop="srWeight">
        <el-input
            v-model="queryParams.srWeight"
            placeholder="请输入样品重量"
            clearable
            size="small"
            @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="样品数量" prop="srQuantity">
        <el-input
            v-model="queryParams.srQuantity"
            placeholder="请输入样品数量"
            clearable
            size="small"
            @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="样品单位" prop="srUnit">
        <el-input
            v-model="queryParams.srUnit"
            placeholder="请输入样品单位"
            clearable
            size="small"
            @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收样时间" prop="srTime">
        <el-date-picker clearable size="small"
                        v-model="queryParams.srTime"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="选择收样时间">
        </el-date-picker>
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
            v-hasPermi="['business:sample:add']"
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
            v-hasPermi="['business:sample:edit']"
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
            v-hasPermi="['business:sample:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
            type="warning"
            plain
            icon="el-icon-download"
            size="mini"
            @click="handleExport"
            v-hasPermi="['business:sample:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="receivingList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="表内顺序编号" align="center" prop="srId" />
      <el-table-column label="样品编号" align="center" prop="srNo" />
      <el-table-column label="样品名称" align="center" prop="srName" />
      <el-table-column label="送样单位" align="center" prop="srDeliveryUnit" />
      <el-table-column label="送样人员" align="center" prop="srUsername" />
      <el-table-column label="送样手机" align="center" prop="srPhone" />
      <el-table-column label="送样地址" align="center" prop="srAddress" />
      <el-table-column label="送样类型:快递,直送" align="center" prop="srType" />
      <el-table-column label="样品特征" align="center" prop="srFeatures" />
      <el-table-column label="样品重量" align="center" prop="srWeight" />
      <el-table-column label="样品数量" align="center" prop="srQuantity" />
      <el-table-column label="样品单位" align="center" prop="srUnit" />
      <el-table-column label="收样时间" align="center" prop="srTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.srTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
              size="mini"
              type="text"
              icon="el-icon-edit"
              @click="handleUpdate(scope.row)"
              v-hasPermi="['business:sample:edit']"
          >修改</el-button>
          <el-button
              size="mini"
              type="text"
              icon="el-icon-delete"
              @click="handleDelete(scope.row)"
              v-hasPermi="['business:sample:remove']"
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

    <!-- 添加或修改样品对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="样品编号" prop="srNo">
          <el-input v-model="form.srNo" placeholder="请输入样品编号" />
        </el-form-item>
        <el-form-item label="样品名称" prop="srName">
          <el-input v-model="form.srName" placeholder="请输入样品名称" />
        </el-form-item>
        <el-form-item label="送样单位" prop="srDeliveryUnit">
          <el-input v-model="form.srDeliveryUnit" placeholder="请输入送样单位" />
        </el-form-item>
        <el-form-item label="送样人员" prop="srUsername">
          <el-input v-model="form.srUsername" placeholder="请输入送样人员" />
        </el-form-item>
        <el-form-item label="送样手机" prop="srPhone">
          <el-input v-model="form.srPhone" placeholder="请输入送样手机" />
        </el-form-item>
        <el-form-item label="送样地址" prop="srAddress">
          <el-input v-model="form.srAddress" placeholder="请输入送样地址" />
        </el-form-item>
        <el-form-item label="样品特征" prop="srFeatures">
          <el-input v-model="form.srFeatures" placeholder="请输入样品特征" />
        </el-form-item>
        <el-form-item label="样品重量" prop="srWeight">
          <el-input v-model="form.srWeight" placeholder="请输入样品重量" />
        </el-form-item>
        <el-form-item label="样品数量" prop="srQuantity">
          <el-input v-model="form.srQuantity" placeholder="请输入样品数量" />
        </el-form-item>
        <el-form-item label="样品单位" prop="srUnit">
          <el-input v-model="form.srUnit" placeholder="请输入样品单位" />
        </el-form-item>
        <el-form-item label="收样时间" prop="srTime">
          <el-date-picker clearable size="small"
                          v-model="form.srTime"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择收样时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
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
import { listReceiving, getReceiving, delReceiving, addReceiving, updateReceiving } from "@/api/system/receiving";

export default {
  name: "Receiving",
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
      // 【请填写功能名称】表格数据
      receivingList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        srNo: null,
        srName: null,
        srDeliveryUnit: null,
        srUsername: null,
        srPhone: null,
        srAddress: null,
        srType: null,
        srFeatures: null,
        srWeight: null,
        srQuantity: null,
        srUnit: null,
        srTime: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        srNo: [
          { required: true, message: "样品编号不能为空", trigger: "blur" }
        ],
        srName: [
          { required: true, message: "样品名称不能为空", trigger: "blur" }
        ],
        srUsername: [
          { required: true, message: "送样人员不能为空", trigger: "blur" }
        ],
        srPhone: [
          { required: true, message: "送样手机不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询样品列表 */
    getList() {
      this.loading = true;
      listReceiving(this.queryParams).then(response => {
        this.receivingList = response.rows;
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
        srId: null,
        srNo: null,
        srName: null,
        srDeliveryUnit: null,
        srUsername: null,
        srPhone: null,
        srAddress: null,
        srType: null,
        srFeatures: null,
        srWeight: null,
        srQuantity: null,
        srUnit: null,
        srTime: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
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
      this.ids = selection.map(item => item.srId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加样品";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const srId = row.srId || this.ids
      getReceiving(srId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改样品";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.srId != null) {
            updateReceiving(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addReceiving(this.form).then(response => {
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
      const srIds = row.srId || this.ids;
      this.$modal.confirm('是否确认删除【请填写功能名称】编号为"' + srIds + '"的数据项？').then(function() {
        return delReceiving(srIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('business/sample/export', {
        ...this.queryParams
      }, `receiving_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
