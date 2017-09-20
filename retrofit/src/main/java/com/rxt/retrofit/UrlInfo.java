package com.rxt.retrofit;

/**
 * 所有的网络请求链接
 * Created by raoxuting on 2016/11/30.
 */

public interface UrlInfo {

    /**
     * 登录接口
     */
    String LoggingUrl = "http://www.gtrsp.com:8081/api/Login/GetLogin";
    /**
     * 发送验证码
     */
    String SendVerifyCode = "http://www.gtrsp.com/Register/SendRegister_MessageApp";
    /**
     * 判断用户名是否被注册过
     */
    String CHECKUSERNAME_URL = "http://www.gtrsp.com:8081/api/User/TPIUser_LoginNameJudge";
    /**
     * 判断手机号是否被注册过
     */
    String CheckPhoneUrl = "http://www.gtrsp.com:8081/api/User/getJudgeMobile_IsRegistered";
    /**
     * 注册
     */
    String RegisterUrl = "http://www.gtrsp.com:8081/api/User/PostOperateSaveData_Register";
    /**
     * 用户协议
     */
    String USER_AGREEMENT_URL = "http://qcn.gtrsp.com/MobileWebs/UserAgreement";
    /**
     * 根据id获取用户信息/机构详情
     */
    String GetUserInfo = "http://www.gtrsp.com:8081/api/LabCompany/GetCompanyDetail";
    /**
     * 上传用户头像
     */
    String UploadUserAvator = "http://www.gtrsp.com:8081/api/User/PostUploadImage";
    /**
     * 服务器头像路径
     */
    String ServiceAvatorPath = "/upload/avatar/";
    /**
     * 服务器修改用户头像
     */
    String ModifyAvatorUrl = "http://www.gtrsp.com:8081/api/User/PostUpdateAvater";
    /**
     * 重置密码
     */
    String RESET_PASSWORD_URL = "http://www.gtrsp.com:8081/api/User/PostOperateSecuritySet_UpdatePsd";
    /**
     * 首页
     */
    String HomePageUrl = "http://www.gtrsp.com:8081/api/index/GetIndex";
    /**
     * 图片前缀
     */
    String ImagePrefixUrl = "http://www.gtrsp.com";
    /**
     * 搜索机构
     */
    String SearchInstiUrl = "http://www.gtrsp.com:8081/api/LabCompany/GetSearchCompany";

    /**
     * 专题立即咨询点击用拦截链接
     */
    String ConsulationUrl = "http://www.gtrsp.com/";
    /**
     * 支付宝生成订单信息
     */
    String GetOrderInfoUrl = "http://www.gtrsp.com:8081/api/AliPay/GetTestPay";
    /**
     * 查询支付宝订单支付是否成功
     */
    //http://www.gtrsp.com:8081/api/AliPay/GetSearchStatu
    String CheckIfAlipaySuccess = "http://www.gtrsp.com:8081/api/AliPay/GetSearchStatu";
    /**
     * 服务方案
     */
    String SolutionUrl = "http://www.gtrsp.com:8081/api/TestService/getTestServiceList";
    /**
     * 搜索服务方案
     */
    String SearchSolutionUrl = "http://www.gtrsp.com:8081/api/TestService/getSearchSolution";
    /**
     * 方案详情
     */
    String SolutionDetailUrl = "http://www.gtrsp.com:8081/api/TestService/getTestServiveDetail";
    /**
     * 方案详情中的服务详情
     */
    String ServiceDetailUrl = "http://www.gtrsp.com/sellweb/TestServiceDetailsMoblieSolution" +
            "Description?TestServiceId=";
    /**
     * 服务机构
     */
    String ServiceInstiUrl = "http://www.gtrsp.com:8081/api/LabCompany/GetCompany";
    /**
     * 提交需求
     */
    String CommitDemandUrl = "http://www.gtrsp.com:8081/api/UserQusetions/PostSaveUserQusetion";
    /**
     * 机构详情机构简介
     */
    String InstiIntroUrl = "http://www.gtrsp.com/SellWeb/AgencyIntro?TPIUserId=";
    /**
     * 资讯详情
     */
    String NewsDetailUrl = "http://www.gtrsp.com/basicdata/Get_GTRSPNewsDetailMobile?NewsId=";
    /**
     * 获取所有订单
     */
    String AllOrderUrl = "http://www.gtrsp.com:8081/api/MobileOrder/getMobileOrderList";
    /**
     * 获取未付款订单
     */
    String WaitPayOrderUrl = "http://www.gtrsp.com:8081/api/MobileOrder/getMobileOrderUnPay";
    /**
     * 获取已付款订单
     */
    String PaidOrderUrl = "http://www.gtrsp.com:8081/api/MobileOrder/getMobileOrderPayed";
    /**
     * 政策法规
     */
    String News_lawUrl = "http://www.gtrsp.com:8081/api/GtrspNews/Get_law";
    /**
     * 机构动态
     */
    String News_instiUrl = "http://www.gtrsp.com:8081/api/GtrspNews/Get_jgdt";
    /**
     * 业界资讯
     */
    String News_industryUrl = "http://www.gtrsp.com:8081/api/GtrspNews/Get_yjzx";
    /**
     * 行业资料
     */
    String News_standardUrl = "http://www.gtrsp.com:8081/api/GtrspNews/Get_ZL";
    /**
     * 修改手机号码
     */
    String Update_CellPhoneNumberUrl = "http://www.gtrsp.com:8081/api/User/PostUpdateMobile";
    /**
     * 获取生成委托单初始化信息
     */
    String Generate_OrderformInitUrl = "http://www.gtrsp.com:8081/api/OrderProcess/PostContractAgreeMent";
    /**
     * 委托单样品图片前缀
     */
    String SamplePrefixUrl = "/upload/ContractSample_Image/";
    /**
     * 上传委托单样品图片
     */
    String UploadSamplePicUrl = "http://www.gtrsp.com:8081/api/OrderProcess/PostUploadImage";
    /**
     * 提交委托单
     */
    String CommitOrderformUrl = "http://www.gtrsp.com:8081/api/OrderProcess/PostSaveContractAgreeMent";
    /**
     * 委托方查看委托单
     */
    String GetOrderformUrl = "http://www.gtrsp.com:8081/api/OrderProcess/getView_SignedContract";
    /**
     * 委托方修改委托单
     */
    String UpdateOrderformUrl = "http://www.gtrsp.com:8081/api/OrderProcess/PostUpdateContractAgreeMent";
    /**
     * 查询地址
     */
    String GetAddressUrl = "http://www.gtrsp.com:8081/api/User/GetAddressByid";
    /**
     * 新增地址
     */
    String UploadNewAddressUrl = "http://www.gtrsp.com:8081/api/User/PostInsertAddress";
    /**
     * 查询地址列表
     */
    String GetAddressListUrl = "http://www.gtrsp.com:8081/api/User/GetAddressListByUserid";
    /**
     * 修改地址
     */
    String UpdateAddressUrl = "http://www.gtrsp.com:8081/api/User/PostUpdataAddress";
    /**
     * 删除地址
     */
    String DeleteAddressUrl = "http://www.gtrsp.com:8081/api/User/PostDeleteAddress";
    /**
     * 行政区json数据
     */
    String GetAreaDataUrl = "http://passer-by.com/data_location/list.json";
    /**
     * 获取市级数据
     */
    String GetCityLevelUrl = "http://www.gtrsp.com:8081/api/User/getCityByprovinceID";
    /**
     * 查看订单进程
     */
    String CheckOrderProgressUrl = "http://www.gtrsp.com:8081/api/OrderProcess/getOrderProceeStatus";
    /**
     * 获取我发布的方案
     */
    String GetMySolutionsUrl = "http://www.gtrsp.com:8081/api/User/getSolutionList";
    /**
     * 删除发布的方案
     */
    String DeleteReleaseSolutionUrl = "http://www.gtrsp.com:8081/api/User/DeleteTestService_Seller";
    /**
     * 密码验证
     */
    String checkPasswordUrl = "http://www.gtrsp.com:8081/api/User/PostValidatePwd";
}
