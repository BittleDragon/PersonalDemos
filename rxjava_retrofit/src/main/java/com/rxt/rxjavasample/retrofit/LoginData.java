package com.rxt.rxjavasample.retrofit;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 登录返回的结果
 * Created by raoxuting on 2017/3/28.
 */

public class LoginData {

    /**
     * ErrorCode : 68879
     * user : {"TPIUserId":68879,"TPIUserName":"HZCM","UserNo":"U2017000078","TPIUserPwd":"44b13955235245b2497399d7a934297f","TPIUserRealName":null,"Email":null,"Sex":null,"MobilePhone":"15925695081","BirthDate":null,"CompanyName":null,"Tel":null,"Fax":null,"ZipCode":null,"Area":null,"Address":null,"TPIUserType":1,"QualityCertificate":null,"LabName":null,"Contact":null,"ContactMobile":null,"ContactEmail":null,"BankAccount":null,"RegDate":"/Date(1496628312603)/","IsView":1,"QQ":null,"OrganizationCode":null,"Website":null,"TestAgencyInfo":null,"IosToken":null,"ticketToken":"35779B2FEB01EECD15EE83138D1BE111CE28CF633632F8B89AB4D23A52F71621ED0237DA6260B1900CD50A96279C5205727361779846CAB8FEFD1033A9FEC57314FCEFEE6A9AEF531C809BB4C4EE01F89E241C82ED1D28060E13BDEB29178D86CB46F80C852BDF8FC4BAC3A6BE2F42E7","ContactTel":null,"Hits":null,"IsFeature":null,"TestAgencyLogo":null,"Avatar":null,"PicOne":null,"PicTwo":null,"PicThird":null,"SampleReport":null,"SiteTemplate":null,"AboutUsLogo":null,"C_Contact":null,"C_Tel":null,"C_Fax":null,"C_ContactMobile":null,"C_QQ":null,"C_Email":null,"C_CompanyName":null,"C_YSZZH":null,"C_Area":null,"C_Address":null,"C_ZipCode":null,"C_WebSite":null,"C_CompanyInfo":null,"LastLoginTime":"/Date(1496629376840)/","LastLoginIP":"121.40.110.116","Qualifications":null,"IsAudit":1,"AsServiceCredit":null,"AsClientCredit":null,"TSGold":16,"DepositBank":null,"VATNo":null,"RegisterName":"","Avatar_en":null,"PicOne_en":null,"PicTwo_en":null,"PicThird_en":null,"RegisterIP":"121.40.110.116","ActivationTime":null}
     */

    private int ErrorCode;
    private UserBean user;

    public int getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(int ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean implements Parcelable {
        /**
         * TPIUserId : 335
         * TPIUserName : U2014000335
         * UserNo : U2014000335
         * TPIUserPwd : c9be2ce02a03393df17e6b4b959ebeba
         * TPIUserRealName : ,&1XM2HB&ubp
         * Email : nbcrjjszx@126.com
         * Sex : 1
         * MobilePhone : 13395742512
         * BirthDate : null
         * CompanyName : 宁波出入境检验检疫局技术中心
         * Tel : 0574-87169358
         * Fax :
         * ZipCode : 315012
         * Area : 330000,330200
         * Address : 浙江省宁波市马园路9号
         * TPIUserType : 3
         * QualityCertificate : null
         * LabName : null
         * Contact : 陈杰
         * ContactMobile : 13395742512
         * ContactEmail : nbcrjjszx@126.com
         * BankAccount : 332006263012015033471
         * RegDate : /Date(1419040800000)/
         * IsView : 1
         * QQ : null
         * OrganizationCode : 41953885-4
         * Website : http://www.nbciqtc.com/
         * TestAgencyInfo : <p class="MsoNormal" align="left">
         宁波出入境检验检疫局检验检疫技术中心是隶属于宁波检验检疫局的独立事业法人机构，拥<span></span>
         </p>
         <p class="MsoNormal" align="left">
         有一支经验丰富、技术水平较高的队伍，现有员工<b>420</b>余人，其中正高<b>13</b>人、副高<b>52</b>人，中级职称<b>88</b>人，博士<b>14</b>人，硕士<b>82</b>人，大专以上学历占<b>95%</b>。<span></span>
         </p>
         <p class="MsoNormal" align="left">
         技术中心实验室使用面积约<b>41000</b>平方米<b>, </b>拥有各类仪器设备近<b>6030</b>套（台），总价值达<b>4</b>亿多元，包括生物<b>DNA</b>测序仪、电子显微镜、高分辨气相色谱<b>-</b>质谱仪、飞行时间质谱仪、液质联用仪、电感耦合等离子体<b>-</b>质谱仪、<b>X</b>射线衍射仪、<b>X</b>射线荧光光谱仪、扫描电镜、辛烷值机、大容量棉花测试仪、大功率变频稳压电源、高精度温升采集监控分析系统、高精度智能泄漏电流仪等大型精密仪器设备。<span></span>
         </p>
         <p class="MsoNormal" align="left">
         技术中心主要从事进出口食品及农产品、化妆品、矿物、煤、金属与合金类材料和制品、油<span></span>
         </p>
         <p class="MsoNormal" align="left">
         品及其产品、食品接触材料、电气、环境保护、玩具、丝、纤维和纺织品、纸张和包装产品、打火机、公共卫生检测、兽医及动植物检验检疫、化学品分类和鉴定等工作，同时承担检验检疫技术研究与服务等工作。<span></span>
         </p>
         <p class="MsoNormal" align="left">
         技术中心是中国合格评定国家认可委员会（<span>CNAS</span>）认可和计量认证的检测机构，下设食品安全检测分中心、消费品安全检测分中心、生物安全检测分中心、石油化工品安全检测分中心、化学及化学危险品分类鉴定评估分中心、电气安全检测分中心、北仑分中心、慈溪分中心、<span></span>
         </p>
         <p class="MsoNormal" align="left">
         鄞州分中心、余姚分中心、大榭分中心、奉化分中心、宁海分中心、象山分中心和梅山分中心综合实验室，共有动植物检验检疫、食品、矿产品、石油化工品、毒理、包装、危险品、纺织品和校准等<span>33</span>个实验室，其中山水盆景、石油化工、铁矿、水产品、化学危险品分类鉴定和评估、纺织服装、轻工产品、光电电气产品、食品接触材料等<span>9</span>个国家级重点实验室，食品安全、植物检疫、生物安全和医学媒介生物监测等<span>4</span>个区域性中心实验室。<span></span>
         </p>
         * IosToken : null
         * ticketToken : null
         * ContactTel : 0574-87169358
         * Hits : null
         * IsFeature : 20
         * TestAgencyLogo : /upload/avatar/20151021150919086.jpg
         * Avatar : null
         * PicOne :
         * PicTwo :
         * PicThird :
         * SampleReport : null
         * SiteTemplate : null
         * AboutUsLogo :
         * C_Contact : null
         * C_Tel : null
         * C_Fax : null
         * C_ContactMobile : null
         * C_QQ : null
         * C_Email : null
         * C_CompanyName : null
         * C_YSZZH :
         * C_Area : null
         * C_Address : null
         * C_ZipCode : null
         * C_WebSite : null
         * C_CompanyInfo : null
         * LastLoginTime : /Date(1474856510487)/
         * LastLoginIP : 123.158.58.124
         * Qualifications : CNAS,食品检验机构资质认定证书
         * IsAudit : 1
         * AsServiceCredit : null
         * AsClientCredit : null
         * TSGold : null
         * DepositBank : 宁波交通银行柳汀支行
         * VATNo :
         * RegisterName : null
         * Avatar_en : null
         * PicOne_en : null
         * PicTwo_en : null
         * PicThird_en : null
         * RegisterIP : null
         * ActivationTime : null
         */

//        private Object BirthDate;
//        private Object Hits;
//        private Object IsFeature;
//        private Object SampleReport;
//        private Object SiteTemplate;
//        private Object C_Contact;
//        private Object C_Tel;
//        private Object C_Fax;
//        private Object C_ContactMobile;
//        private Object C_QQ;
//        private Object C_Email;
//        private Object C_Area;
//        private Object C_ZipCode;
//        private Object C_WebSite;
//        private Object C_CompanyInfo;

        private int TPIUserId;
        private String TPIUserName;
        private String UserNo;
        private String TPIUserPwd;
        private String TPIUserRealName;
        private String Email;
        private int Sex;
        private String MobilePhone;
        private String CompanyName;
        private String Tel;
        private String Fax;
        private String ZipCode;
        private String Area;
        private String Address;
        private int TPIUserType;
        private String QualityCertificate;
        private String LabName;
        private String Contact;
        private String ContactMobile;
        private String ContactEmail;
        private String BankAccount;
        private String RegDate;
        private int IsView;
        private String QQ;
        private String OrganizationCode;
        private String Website;
        private String TestAgencyInfo;
        private String ContactTel;
        private String C_CompanyName;
        private String C_YSZZH;
        private String C_Address;
        private String IosToken;
        private String ticketToken;
        private String Avatar;
        private String LastLoginTime;
        private String LastLoginIP;
        private String Qualifications;
        private int IsAudit;
        private String AsServiceCredit;
        private String AsClientCredit;
        private int TSGold;
        private String RegisterName;
        private String PicOne;
        private String PicTwo;
        private String PicThird;
        private String Avatar_en;
        private String PicOne_en;
        private String PicTwo_en;
        private String PicThird_en;
        private String AboutUsLogo;
        private String DepositBank;
        private String VATNo;
        private String RegisterIP;
        private String ActivationTime;
        private String TestAgencyLogo;

        public static final Creator<UserBean> CREATOR = new Creator<UserBean>() {
            @Override
            public UserBean createFromParcel(Parcel in) {
                return new UserBean(in);
            }

            @Override
            public UserBean[] newArray(int size) {
                return new UserBean[size];
            }
        };

        public String getPicOne_en() {
            return PicOne_en;
        }

        public void setPicOne_en(String picOne_en) {
            PicOne_en = picOne_en;
        }

        public String getPicTwo_en() {
            return PicTwo_en;
        }

        public void setPicTwo_en(String picTwo_en) {
            PicTwo_en = picTwo_en;
        }

        public String getPicThird_en() {
            return PicThird_en;
        }

        public void setPicThird_en(String picThird_en) {
            PicThird_en = picThird_en;
        }

        public String getPicOne() {
            return PicOne;
        }

        public void setPicOne(String picOne) {
            PicOne = picOne;
        }

        public String getPicTwo() {
            return PicTwo;
        }

        public void setPicTwo(String picTwo) {
            PicTwo = picTwo;
        }

        public String getPicThird() {
            return PicThird;
        }

        public void setPicThird(String picThird) {
            PicThird = picThird;
        }

        public String getAboutUsLogo() {
            return AboutUsLogo;
        }

        public void setAboutUsLogo(String aboutUsLogo) {
            AboutUsLogo = aboutUsLogo;
        }

        public String getDepositBank() {
            return DepositBank;
        }

        public void setDepositBank(String depositBank) {
            DepositBank = depositBank;
        }

        public String getVATNo() {
            return VATNo;
        }

        public void setVATNo(String VATNo) {
            this.VATNo = VATNo;
        }

        public String getTestAgencyLogo() {
            return TestAgencyLogo;
        }

        public void setTestAgencyLogo(String testAgencyLogo) {
            TestAgencyLogo = testAgencyLogo;
        }

        public int getTPIUserId() {
            return TPIUserId;
        }

        public void setTPIUserId(int TPIUserId) {
            this.TPIUserId = TPIUserId;
        }

        public String getTPIUserName() {
            return TPIUserName;
        }

        public void setTPIUserName(String TPIUserName) {
            this.TPIUserName = TPIUserName;
        }

        public String getUserNo() {
            return UserNo;
        }

        public void setUserNo(String UserNo) {
            this.UserNo = UserNo;
        }

        public String getTPIUserPwd() {
            return TPIUserPwd;
        }

        public void setTPIUserPwd(String TPIUserPwd) {
            this.TPIUserPwd = TPIUserPwd;
        }

        public String getTPIUserRealName() {
            return TPIUserRealName;
        }

        public void setTPIUserRealName(String TPIUserRealName) {
            this.TPIUserRealName = TPIUserRealName;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String Email) {
            this.Email = Email;
        }

        public int getSex() {
            return Sex;
        }

        public void setSex(int Sex) {
            this.Sex = Sex;
        }

        public String getMobilePhone() {
            return MobilePhone;
        }

        public void setMobilePhone(String MobilePhone) {
            this.MobilePhone = MobilePhone;
        }

        public String getCompanyName() {
            return CompanyName;
        }

        public void setCompanyName(String CompanyName) {
            this.CompanyName = CompanyName;
        }

        public String getTel() {
            return Tel;
        }

        public void setTel(String Tel) {
            this.Tel = Tel;
        }

        public String getFax() {
            return Fax;
        }

        public void setFax(String Fax) {
            this.Fax = Fax;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public int getTPIUserType() {
            return TPIUserType;
        }

        public void setTPIUserType(int TPIUserType) {
            this.TPIUserType = TPIUserType;
        }

        public String getQualityCertificate() {
            return QualityCertificate;
        }

        public void setQualityCertificate(String QualityCertificate) {
            this.QualityCertificate = QualityCertificate;
        }

        public String getLabName() {
            return LabName;
        }

        public void setLabName(String LabName) {
            this.LabName = LabName;
        }

        public String getContact() {
            return Contact;
        }

        public void setContact(String Contact) {
            this.Contact = Contact;
        }

        public String getContactMobile() {
            return ContactMobile;
        }

        public void setContactMobile(String ContactMobile) {
            this.ContactMobile = ContactMobile;
        }

        public String getContactEmail() {
            return ContactEmail;
        }

        public void setContactEmail(String ContactEmail) {
            this.ContactEmail = ContactEmail;
        }

        public String getBankAccount() {
            return BankAccount;
        }

        public void setBankAccount(String BankAccount) {
            this.BankAccount = BankAccount;
        }

        public String getRegDate() {
            return RegDate;
        }

        public void setRegDate(String RegDate) {
            this.RegDate = RegDate;
        }

        public int getIsView() {
            return IsView;
        }

        public void setIsView(int IsView) {
            this.IsView = IsView;
        }

        public String getQQ() {
            return QQ;
        }

        public void setQQ(String QQ) {
            this.QQ = QQ;
        }

        public String getOrganizationCode() {
            return OrganizationCode;
        }

        public void setOrganizationCode(String OrganizationCode) {
            this.OrganizationCode = OrganizationCode;
        }

        public String getWebsite() {
            return Website;
        }

        public void setWebsite(String Website) {
            this.Website = Website;
        }

        public String getTestAgencyInfo() {
            return TestAgencyInfo;
        }

        public void setTestAgencyInfo(String TestAgencyInfo) {
            this.TestAgencyInfo = TestAgencyInfo;
        }

        public String getIosToken() {
            return IosToken;
        }

        public void setIosToken(String IosToken) {
            this.IosToken = IosToken;
        }

        public String getTicketToken() {
            return ticketToken;
        }

        public void setTicketToken(String ticketToken) {
            this.ticketToken = ticketToken;
        }

        public String getAvatar() {
            return Avatar;
        }

        public void setAvatar(String Avatar) {
            this.Avatar = Avatar;
        }

        public String getLastLoginTime() {
            return LastLoginTime;
        }

        public void setLastLoginTime(String LastLoginTime) {
            this.LastLoginTime = LastLoginTime;
        }

        public String getLastLoginIP() {
            return LastLoginIP;
        }

        public void setLastLoginIP(String LastLoginIP) {
            this.LastLoginIP = LastLoginIP;
        }

        public String getQualifications() {
            return Qualifications;
        }

        public void setQualifications(String Qualifications) {
            this.Qualifications = Qualifications;
        }

        public int getIsAudit() {
            return IsAudit;
        }

        public void setIsAudit(int IsAudit) {
            this.IsAudit = IsAudit;
        }

        public String getAsServiceCredit() {
            return AsServiceCredit;
        }

        public void setAsServiceCredit(String AsServiceCredit) {
            this.AsServiceCredit = AsServiceCredit;
        }

        public String getAsClientCredit() {
            return AsClientCredit;
        }

        public void setAsClientCredit(String AsClientCredit) {
            this.AsClientCredit = AsClientCredit;
        }

        public int getTSGold() {
            return TSGold;
        }

        public void setTSGold(int TSGold) {
            this.TSGold = TSGold;
        }

        public String getRegisterName() {
            return RegisterName;
        }

        public void setRegisterName(String RegisterName) {
            this.RegisterName = RegisterName;
        }

        public String getAvatar_en() {
            return Avatar_en;
        }

        public void setAvatar_en(String Avatar_en) {
            this.Avatar_en = Avatar_en;
        }

        public String getRegisterIP() {
            return RegisterIP;
        }

        public void setRegisterIP(String RegisterIP) {
            this.RegisterIP = RegisterIP;
        }

        public String getActivationTime() {
            return ActivationTime;
        }

        public void setActivationTime(String ActivationTime) {
            this.ActivationTime = ActivationTime;
        }

        public String getZipCode() {
            return ZipCode;
        }

        public void setZipCode(String zipCode) {
            ZipCode = zipCode;
        }

        public String getArea() {
            return Area;
        }

        public void setArea(String area) {
            Area = area;
        }

        public String getContactTel() {
            return ContactTel;
        }

        public void setContactTel(String contactTel) {
            ContactTel = contactTel;
        }

        public String getC_CompanyName() {
            return C_CompanyName;
        }

        public void setC_CompanyName(String c_CompanyName) {
            C_CompanyName = c_CompanyName;
        }

        public String getC_YSZZH() {
            return C_YSZZH;
        }

        public void setC_YSZZH(String c_YSZZH) {
            C_YSZZH = c_YSZZH;
        }

        public String getC_Address() {
            return C_Address;
        }

        public void setC_Address(String c_Address) {
            C_Address = c_Address;
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.TPIUserId);
            dest.writeString(this.TPIUserName);
            dest.writeString(this.UserNo);
            dest.writeString(this.TPIUserPwd);
            dest.writeString(this.TPIUserRealName);
            dest.writeString(this.Email);
            dest.writeInt(this.Sex);
            dest.writeString(this.MobilePhone);
            dest.writeString(this.CompanyName);
            dest.writeString(this.Tel);
            dest.writeString(this.Fax);
            dest.writeString(this.ZipCode);
            dest.writeString(this.Area);
            dest.writeString(this.Address);
            dest.writeInt(this.TPIUserType);
            dest.writeString(this.QualityCertificate);
            dest.writeString(this.LabName);
            dest.writeString(this.Contact);
            dest.writeString(this.ContactMobile);
            dest.writeString(this.ContactEmail);
            dest.writeString(this.BankAccount);
            dest.writeString(this.RegDate);
            dest.writeInt(this.IsView);
            dest.writeString(this.QQ);
            dest.writeString(this.OrganizationCode);
            dest.writeString(this.Website);
            dest.writeString(this.TestAgencyInfo);
            dest.writeString(this.ContactTel);
            dest.writeString(this.C_CompanyName);
            dest.writeString(this.C_YSZZH);
            dest.writeString(this.C_Address);
            dest.writeString(this.IosToken);
            dest.writeString(this.ticketToken);
            dest.writeString(this.Avatar);
            dest.writeString(this.LastLoginTime);
            dest.writeString(this.LastLoginIP);
            dest.writeString(this.Qualifications);
            dest.writeInt(this.IsAudit);
            dest.writeString(this.AsServiceCredit);
            dest.writeString(this.AsClientCredit);
            dest.writeInt(this.TSGold);
            dest.writeString(this.RegisterName);
            dest.writeString(this.PicOne);
            dest.writeString(this.PicTwo);
            dest.writeString(this.PicThird);
            dest.writeString(this.Avatar_en);
            dest.writeString(this.PicOne_en);
            dest.writeString(this.PicTwo_en);
            dest.writeString(this.PicThird_en);
            dest.writeString(this.AboutUsLogo);
            dest.writeString(this.DepositBank);
            dest.writeString(this.VATNo);
            dest.writeString(this.RegisterIP);
            dest.writeString(this.ActivationTime);
            dest.writeString(this.TestAgencyLogo);
        }

        public UserBean() {
        }

        protected UserBean(Parcel in) {
            this.TPIUserId = in.readInt();
            this.TPIUserName = in.readString();
            this.UserNo = in.readString();
            this.TPIUserPwd = in.readString();
            this.TPIUserRealName = in.readString();
            this.Email = in.readString();
            this.Sex = in.readInt();
            this.MobilePhone = in.readString();
            this.CompanyName = in.readString();
            this.Tel = in.readString();
            this.Fax = in.readString();
            this.ZipCode = in.readString();
            this.Area = in.readString();
            this.Address = in.readString();
            this.TPIUserType = in.readInt();
            this.QualityCertificate = in.readString();
            this.LabName = in.readString();
            this.Contact = in.readString();
            this.ContactMobile = in.readString();
            this.ContactEmail = in.readString();
            this.BankAccount = in.readString();
            this.RegDate = in.readString();
            this.IsView = in.readInt();
            this.QQ = in.readString();
            this.OrganizationCode = in.readString();
            this.Website = in.readString();
            this.TestAgencyInfo = in.readString();
            this.ContactTel = in.readString();
            this.C_CompanyName = in.readString();
            this.C_YSZZH = in.readString();
            this.C_Address = in.readString();
            this.IosToken = in.readString();
            this.ticketToken = in.readString();
            this.Avatar = in.readString();
            this.LastLoginTime = in.readString();
            this.LastLoginIP = in.readString();
            this.Qualifications = in.readString();
            this.IsAudit = in.readInt();
            this.AsServiceCredit = in.readString();
            this.AsClientCredit = in.readString();
            this.TSGold = in.readInt();
            this.RegisterName = in.readString();
            this.PicOne = in.readString();
            this.PicTwo = in.readString();
            this.PicThird = in.readString();
            this.Avatar_en = in.readString();
            this.PicOne_en = in.readString();
            this.PicTwo_en = in.readString();
            this.PicThird_en = in.readString();
            this.AboutUsLogo = in.readString();
            this.DepositBank = in.readString();
            this.VATNo = in.readString();
            this.RegisterIP = in.readString();
            this.ActivationTime = in.readString();
            this.TestAgencyLogo = in.readString();
        }

    }
}
