<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="会员信息卡ID" prop="membershipLevel">
        <el-input
          v-model="queryParams.membershipLevel"
          placeholder="请输入会员信息卡ID"
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
          v-hasPermi="['fee:membershipCardInformation:add']"
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
          v-hasPermi="['fee:membershipCardInformation:edit']"
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
          v-hasPermi="['fee:membershipCardInformation:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['fee:membershipCardInformation:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="informationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="会员卡信息ID" align="center" prop="membershipCardInformationId" />
      <el-table-column label="会员等级" align="center" prop="membershipLevel" />
      <el-table-column label="会员折扣" align="center" prop="memberDiscount" />
      <el-table-column label="购买金额" align="center" prop="purchaseAmount" />
      <el-table-column label="有限时间" align="center" prop="limitedTime" />
      <el-table-column label="购买详情" align="center" prop="purchaseDetails" />
      <el-table-column label="智能推荐" align="center" prop="recommend" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['fee:membershipCardInformation:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['fee:membershipCardInformation:remove']"
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

    <!-- 添加或修改会员卡信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="会员等级" prop="membershipLevel">
          <el-input v-model="form.membershipLevel" placeholder="请输入会员等级" />
        </el-form-item>
        <el-form-item label="会员折扣" prop="memberDiscount">
          <el-input v-model="form.memberDiscount" placeholder="请输入会员折扣" />
        </el-form-item>
        <el-form-item label="购买金额" prop="purchaseAmount">
          <el-input v-model="form.purchaseAmount" placeholder="请输入购买金额" />
        </el-form-item>
        <el-form-item label="有限时间" prop="limitedTime">
          <el-input v-model="form.limitedTime" placeholder="请输入有限时间" />
        </el-form-item>
        <el-form-item label="购买详情" prop="purchaseDetails">
          <el-input v-model="form.purchaseDetails" type="textarea" placeholder="请输入内容" />
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
import { listInformation, getInformation, delInformation, addInformation, updateInformation } from "@/api/fee/membershipCardInformation";

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
      // 会员卡信息表格数据
      informationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        membershipLevel: null,
        memberDiscount: null,
        purchaseAmount: null,
        limitedTime: null,
        purchaseDetails: null,
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
    /** 查询会员卡信息列表 */
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
        membershipCardInformationId: null,
        membershipLevel: null,
        memberDiscount: null,
        purchaseAmount: null,
        limitedTime: null,
        purchaseDetails: null,
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
      this.ids = selection.map(item => item.membershipCardInformationId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加会员卡信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const membershipCardInformationId = row.membershipCardInformationId || this.ids
      getInformation(membershipCardInformationId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改会员卡信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.membershipCardInformationId != null) {
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
      const membershipCardInformationIds = row.membershipCardInformationId || this.ids;
      this.$modal.confirm('是否确认删除会员卡信息编号为"' + membershipCardInformationIds + '"的数据项？').then(function() {
        return delInformation(membershipCardInformationIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/information/export', {
        ...this.queryParams
      }, `information_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
