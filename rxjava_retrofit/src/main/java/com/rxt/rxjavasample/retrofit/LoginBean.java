package com.rxt.rxjavasample.retrofit;

/**
 * Created by raoxuting on 2017/9/15.
 */

public class LoginBean {


    /**
     * ErrorCode : 68879
     * user : {"TPIUserId":68879,"TPIUserName":"HZCM","UserNo":"U2017000078","TPIUserPwd":"44b13955235245b2497399d7a934297f","TPIUserRealName":null,"Email":null,"Sex":null,"MobilePhone":"15925695081","BirthDate":null,"CompanyName":null,"Tel":null,"Fax":null,"ZipCode":null,"Area":null,"Address":null,"TPIUserType":1,"QualityCertificate":null,"LabName":null,"Contact":null,"ContactMobile":null,"ContactEmail":null,"BankAccount":null,"RegDate":"/Date(1496628312603)/","IsView":1,"QQ":null,"OrganizationCode":null,"Website":null,"TestAgencyInfo":null,"IosToken":null,"ticketToken":"8F5294A69342AA0F4C18CF0C597524227C40C32521721F3ECF1B4415B6E93F55B91556F3A034F6E6DFBC17D62B74B2D0A8122FC81808B6B6ED33E5BEA6FC0C190E05B3359C98C3B7EF05ECF1596E2D0F6833C1154EB68400B8E05A4C55D22A79BD6BC0D6FB604888132F5E4F7F6FD1B9","ContactTel":null,"Hits":null,"IsFeature":null,"TestAgencyLogo":null,"Avatar":"/upload/avatar/1503911837448avator.jpg","PicOne":null,"PicTwo":null,"PicThird":null,"SampleReport":null,"SiteTemplate":null,"AboutUsLogo":null,"C_Contact":null,"C_Tel":null,"C_Fax":null,"C_ContactMobile":null,"C_QQ":null,"C_Email":null,"C_CompanyName":null,"C_YSZZH":null,"C_Area":null,"C_Address":null,"C_ZipCode":null,"C_WebSite":null,"C_CompanyInfo":null,"LastLoginTime":"/Date(1497237592193)/","LastLoginIP":"223.93.178.152","Qualifications":null,"IsAudit":1,"AsServiceCredit":null,"AsClientCredit":null,"TSGold":434,"DepositBank":null,"VATNo":null,"RegisterName":"","Avatar_en":null,"PicOne_en":null,"PicTwo_en":null,"PicThird_en":null,"RegisterIP":"121.40.110.116","ActivationTime":null}
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

    public static class UserBean {
        /**
         * TPIUserId : 68879
         * TPIUserName : HZCM
         * UserNo : U2017000078
         * TPIUserPwd : 44b13955235245b2497399d7a934297f
         * TPIUserRealName : null
         * Email : null
         * Sex : null
         * MobilePhone : 15925695081
         * BirthDate : null
         * CompanyName : null
         * Tel : null
         * Fax : null
         * ZipCode : null
         * Area : null
         * Address : null
         * TPIUserType : 1
         * QualityCertificate : null
         * LabName : null
         * Contact : null
         * ContactMobile : null
         * ContactEmail : null
         * BankAccount : null
         * RegDate : /Date(1496628312603)/
         * IsView : 1
         * QQ : null
         * OrganizationCode : null
         * Website : null
         * TestAgencyInfo : null
         * IosToken : null
         * ticketToken : 8F5294A69342AA0F4C18CF0C597524227C40C32521721F3ECF1B4415B6E93F55B91556F3A034F6E6DFBC17D62B74B2D0A8122FC81808B6B6ED33E5BEA6FC0C190E05B3359C98C3B7EF05ECF1596E2D0F6833C1154EB68400B8E05A4C55D22A79BD6BC0D6FB604888132F5E4F7F6FD1B9
         * ContactTel : null
         * Hits : null
         * IsFeature : null
         * TestAgencyLogo : null
         * Avatar : /upload/avatar/1503911837448avator.jpg
         * PicOne : null
         * PicTwo : null
         * PicThird : null
         * SampleReport : null
         * SiteTemplate : null
         * AboutUsLogo : null
         * C_Contact : null
         * C_Tel : null
         * C_Fax : null
         * C_ContactMobile : null
         * C_QQ : null
         * C_Email : null
         * C_CompanyName : null
         * C_YSZZH : null
         * C_Area : null
         * C_Address : null
         * C_ZipCode : null
         * C_WebSite : null
         * C_CompanyInfo : null
         * LastLoginTime : /Date(1497237592193)/
         * LastLoginIP : 223.93.178.152
         * Qualifications : null
         * IsAudit : 1
         * AsServiceCredit : null
         * AsClientCredit : null
         * TSGold : 434
         * DepositBank : null
         * VATNo : null
         * RegisterName :
         * Avatar_en : null
         * PicOne_en : null
         * PicTwo_en : null
         * PicThird_en : null
         * RegisterIP : 121.40.110.116
         * ActivationTime : null
         */

        private int TPIUserId;
        private String TPIUserName;
        private String UserNo;
        private String TPIUserPwd;
        private Object TPIUserRealName;
        private Object Email;
        private Object Sex;
        private String MobilePhone;
        private Object BirthDate;
        private Object CompanyName;
        private Object Tel;
        private Object Fax;
        private Object ZipCode;
        private Object Area;
        private Object Address;
        private int TPIUserType;
        private Object QualityCertificate;
        private Object LabName;
        private Object Contact;
        private Object ContactMobile;
        private Object ContactEmail;
        private Object BankAccount;
        private String RegDate;
        private int IsView;
        private Object QQ;
        private Object OrganizationCode;
        private Object Website;
        private Object TestAgencyInfo;
        private Object IosToken;
        private String ticketToken;
        private Object ContactTel;
        private Object Hits;
        private Object IsFeature;
        private Object TestAgencyLogo;
        private String Avatar;
        private Object PicOne;
        private Object PicTwo;
        private Object PicThird;
        private Object SampleReport;
        private Object SiteTemplate;
        private Object AboutUsLogo;
        private Object C_Contact;
        private Object C_Tel;
        private Object C_Fax;
        private Object C_ContactMobile;
        private Object C_QQ;
        private Object C_Email;
        private Object C_CompanyName;
        private Object C_YSZZH;
        private Object C_Area;
        private Object C_Address;
        private Object C_ZipCode;
        private Object C_WebSite;
        private Object C_CompanyInfo;
        private String LastLoginTime;
        private String LastLoginIP;
        private Object Qualifications;
        private int IsAudit;
        private Object AsServiceCredit;
        private Object AsClientCredit;
        private int TSGold;
        private Object DepositBank;
        private Object VATNo;
        private String RegisterName;
        private Object Avatar_en;
        private Object PicOne_en;
        private Object PicTwo_en;
        private Object PicThird_en;
        private String RegisterIP;
        private Object ActivationTime;

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

        public Object getTPIUserRealName() {
            return TPIUserRealName;
        }

        public void setTPIUserRealName(Object TPIUserRealName) {
            this.TPIUserRealName = TPIUserRealName;
        }

        public Object getEmail() {
            return Email;
        }

        public void setEmail(Object Email) {
            this.Email = Email;
        }

        public Object getSex() {
            return Sex;
        }

        public void setSex(Object Sex) {
            this.Sex = Sex;
        }

        public String getMobilePhone() {
            return MobilePhone;
        }

        public void setMobilePhone(String MobilePhone) {
            this.MobilePhone = MobilePhone;
        }

        public Object getBirthDate() {
            return BirthDate;
        }

        public void setBirthDate(Object BirthDate) {
            this.BirthDate = BirthDate;
        }

        public Object getCompanyName() {
            return CompanyName;
        }

        public void setCompanyName(Object CompanyName) {
            this.CompanyName = CompanyName;
        }

        public Object getTel() {
            return Tel;
        }

        public void setTel(Object Tel) {
            this.Tel = Tel;
        }

        public Object getFax() {
            return Fax;
        }

        public void setFax(Object Fax) {
            this.Fax = Fax;
        }

        public Object getZipCode() {
            return ZipCode;
        }

        public void setZipCode(Object ZipCode) {
            this.ZipCode = ZipCode;
        }

        public Object getArea() {
            return Area;
        }

        public void setArea(Object Area) {
            this.Area = Area;
        }

        public Object getAddress() {
            return Address;
        }

        public void setAddress(Object Address) {
            this.Address = Address;
        }

        public int getTPIUserType() {
            return TPIUserType;
        }

        public void setTPIUserType(int TPIUserType) {
            this.TPIUserType = TPIUserType;
        }

        public Object getQualityCertificate() {
            return QualityCertificate;
        }

        public void setQualityCertificate(Object QualityCertificate) {
            this.QualityCertificate = QualityCertificate;
        }

        public Object getLabName() {
            return LabName;
        }

        public void setLabName(Object LabName) {
            this.LabName = LabName;
        }

        public Object getContact() {
            return Contact;
        }

        public void setContact(Object Contact) {
            this.Contact = Contact;
        }

        public Object getContactMobile() {
            return ContactMobile;
        }

        public void setContactMobile(Object ContactMobile) {
            this.ContactMobile = ContactMobile;
        }

        public Object getContactEmail() {
            return ContactEmail;
        }

        public void setContactEmail(Object ContactEmail) {
            this.ContactEmail = ContactEmail;
        }

        public Object getBankAccount() {
            return BankAccount;
        }

        public void setBankAccount(Object BankAccount) {
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

        public Object getQQ() {
            return QQ;
        }

        public void setQQ(Object QQ) {
            this.QQ = QQ;
        }

        public Object getOrganizationCode() {
            return OrganizationCode;
        }

        public void setOrganizationCode(Object OrganizationCode) {
            this.OrganizationCode = OrganizationCode;
        }

        public Object getWebsite() {
            return Website;
        }

        public void setWebsite(Object Website) {
            this.Website = Website;
        }

        public Object getTestAgencyInfo() {
            return TestAgencyInfo;
        }

        public void setTestAgencyInfo(Object TestAgencyInfo) {
            this.TestAgencyInfo = TestAgencyInfo;
        }

        public Object getIosToken() {
            return IosToken;
        }

        public void setIosToken(Object IosToken) {
            this.IosToken = IosToken;
        }

        public String getTicketToken() {
            return ticketToken;
        }

        public void setTicketToken(String ticketToken) {
            this.ticketToken = ticketToken;
        }

        public Object getContactTel() {
            return ContactTel;
        }

        public void setContactTel(Object ContactTel) {
            this.ContactTel = ContactTel;
        }

        public Object getHits() {
            return Hits;
        }

        public void setHits(Object Hits) {
            this.Hits = Hits;
        }

        public Object getIsFeature() {
            return IsFeature;
        }

        public void setIsFeature(Object IsFeature) {
            this.IsFeature = IsFeature;
        }

        public Object getTestAgencyLogo() {
            return TestAgencyLogo;
        }

        public void setTestAgencyLogo(Object TestAgencyLogo) {
            this.TestAgencyLogo = TestAgencyLogo;
        }

        public String getAvatar() {
            return Avatar;
        }

        public void setAvatar(String Avatar) {
            this.Avatar = Avatar;
        }

        public Object getPicOne() {
            return PicOne;
        }

        public void setPicOne(Object PicOne) {
            this.PicOne = PicOne;
        }

        public Object getPicTwo() {
            return PicTwo;
        }

        public void setPicTwo(Object PicTwo) {
            this.PicTwo = PicTwo;
        }

        public Object getPicThird() {
            return PicThird;
        }

        public void setPicThird(Object PicThird) {
            this.PicThird = PicThird;
        }

        public Object getSampleReport() {
            return SampleReport;
        }

        public void setSampleReport(Object SampleReport) {
            this.SampleReport = SampleReport;
        }

        public Object getSiteTemplate() {
            return SiteTemplate;
        }

        public void setSiteTemplate(Object SiteTemplate) {
            this.SiteTemplate = SiteTemplate;
        }

        public Object getAboutUsLogo() {
            return AboutUsLogo;
        }

        public void setAboutUsLogo(Object AboutUsLogo) {
            this.AboutUsLogo = AboutUsLogo;
        }

        public Object getC_Contact() {
            return C_Contact;
        }

        public void setC_Contact(Object C_Contact) {
            this.C_Contact = C_Contact;
        }

        public Object getC_Tel() {
            return C_Tel;
        }

        public void setC_Tel(Object C_Tel) {
            this.C_Tel = C_Tel;
        }

        public Object getC_Fax() {
            return C_Fax;
        }

        public void setC_Fax(Object C_Fax) {
            this.C_Fax = C_Fax;
        }

        public Object getC_ContactMobile() {
            return C_ContactMobile;
        }

        public void setC_ContactMobile(Object C_ContactMobile) {
            this.C_ContactMobile = C_ContactMobile;
        }

        public Object getC_QQ() {
            return C_QQ;
        }

        public void setC_QQ(Object C_QQ) {
            this.C_QQ = C_QQ;
        }

        public Object getC_Email() {
            return C_Email;
        }

        public void setC_Email(Object C_Email) {
            this.C_Email = C_Email;
        }

        public Object getC_CompanyName() {
            return C_CompanyName;
        }

        public void setC_CompanyName(Object C_CompanyName) {
            this.C_CompanyName = C_CompanyName;
        }

        public Object getC_YSZZH() {
            return C_YSZZH;
        }

        public void setC_YSZZH(Object C_YSZZH) {
            this.C_YSZZH = C_YSZZH;
        }

        public Object getC_Area() {
            return C_Area;
        }

        public void setC_Area(Object C_Area) {
            this.C_Area = C_Area;
        }

        public Object getC_Address() {
            return C_Address;
        }

        public void setC_Address(Object C_Address) {
            this.C_Address = C_Address;
        }

        public Object getC_ZipCode() {
            return C_ZipCode;
        }

        public void setC_ZipCode(Object C_ZipCode) {
            this.C_ZipCode = C_ZipCode;
        }

        public Object getC_WebSite() {
            return C_WebSite;
        }

        public void setC_WebSite(Object C_WebSite) {
            this.C_WebSite = C_WebSite;
        }

        public Object getC_CompanyInfo() {
            return C_CompanyInfo;
        }

        public void setC_CompanyInfo(Object C_CompanyInfo) {
            this.C_CompanyInfo = C_CompanyInfo;
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

        public Object getQualifications() {
            return Qualifications;
        }

        public void setQualifications(Object Qualifications) {
            this.Qualifications = Qualifications;
        }

        public int getIsAudit() {
            return IsAudit;
        }

        public void setIsAudit(int IsAudit) {
            this.IsAudit = IsAudit;
        }

        public Object getAsServiceCredit() {
            return AsServiceCredit;
        }

        public void setAsServiceCredit(Object AsServiceCredit) {
            this.AsServiceCredit = AsServiceCredit;
        }

        public Object getAsClientCredit() {
            return AsClientCredit;
        }

        public void setAsClientCredit(Object AsClientCredit) {
            this.AsClientCredit = AsClientCredit;
        }

        public int getTSGold() {
            return TSGold;
        }

        public void setTSGold(int TSGold) {
            this.TSGold = TSGold;
        }

        public Object getDepositBank() {
            return DepositBank;
        }

        public void setDepositBank(Object DepositBank) {
            this.DepositBank = DepositBank;
        }

        public Object getVATNo() {
            return VATNo;
        }

        public void setVATNo(Object VATNo) {
            this.VATNo = VATNo;
        }

        public String getRegisterName() {
            return RegisterName;
        }

        public void setRegisterName(String RegisterName) {
            this.RegisterName = RegisterName;
        }

        public Object getAvatar_en() {
            return Avatar_en;
        }

        public void setAvatar_en(Object Avatar_en) {
            this.Avatar_en = Avatar_en;
        }

        public Object getPicOne_en() {
            return PicOne_en;
        }

        public void setPicOne_en(Object PicOne_en) {
            this.PicOne_en = PicOne_en;
        }

        public Object getPicTwo_en() {
            return PicTwo_en;
        }

        public void setPicTwo_en(Object PicTwo_en) {
            this.PicTwo_en = PicTwo_en;
        }

        public Object getPicThird_en() {
            return PicThird_en;
        }

        public void setPicThird_en(Object PicThird_en) {
            this.PicThird_en = PicThird_en;
        }

        public String getRegisterIP() {
            return RegisterIP;
        }

        public void setRegisterIP(String RegisterIP) {
            this.RegisterIP = RegisterIP;
        }

        public Object getActivationTime() {
            return ActivationTime;
        }

        public void setActivationTime(Object ActivationTime) {
            this.ActivationTime = ActivationTime;
        }
    }
}
