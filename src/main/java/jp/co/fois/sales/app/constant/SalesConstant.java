package jp.co.fois.sales.app.constant;


/**
 * <pre>
 * 営業支援システムの定数クラス.
 * 
 * 【変更履歴】
 * 1.00 2019/05/03 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
public class SalesConstant {

    /** 会社情報画面の担当者情報の最大表示件数. */
    public static final int MAX_STAFF_COUNT = 100;

    /** 1ページに表示する最大データ数. */
    public static final int MAX_PAGE_VIEW_COUNT = 10;

    /** デフォルトページNo. */
    public static final String DEFAULT_PAGE = "1";

    /**
     * ビュー名の定数.
     * 
     * @author YAGI
     */
    public enum ViewName {
        
        /** ログイン画面. */
        Login("login/login", "ログイン"),
        
        /** プロフィール画面. */
        Profile("profile/profile", "プロフィール"),
        
        /** パスワード変更画面. */
        ChangePassword("profile/changePassword", "パスワード変更"),
        
        /** 会社情報一覧画面. */
        CompanyList("company/companyList", "会社情報一覧"),
        
        /** 会社情報登録/更新画面. */
        CompanyForm("company/companyForm", "会社情報登録/更新"),
        
        /** 会社情報確認画面. */
        CompanyFormConfirm("company/companyConfirm", "会社情報確認"),
        
        /** ユーザ一覧画面. */
        UserListForm("user/userList", "ユーザ一覧"),
        
        /** ユーザ登録/更新画面. */
        UserEditForm("user/userEdit", "ユーザ登録/更新"),
        
        /** 営業活動登録画面. */
        SalesActivityForm("activity/salesActivity", "営業活動登録"),
        
        /** 営業活動状況確認画面. */
        SalesActivityConfirm("activity/salesActivityConfirm", "営業活動状況確認"),
        
        /** 会社選択画面. */
        DialogSelectCompany("dialog/company/selectCompany", "会社選択"),
        
        /** 会社検索画面. */
        DialogSearchCompany("dialog/company/searchCompany", "会社検索"),
        
        /** CSV出力画面. */
        CsvInputForm("csv/csvOutput", "CSV出力"),
        
        /** 営業活動状況検索ダイアログ画面. */
        DialogActivitySearch("dialog/activity/activitySearchDialog", "営業活動状況検索ダイアログ");

        private ViewName(String value) {
            this.value = value;
        }

        private ViewName(String value, String viewNameKanji) {
            this.value = value;
            this.viewNameKanji = viewNameKanji;
        }

        /** 画面名. */
        private String viewNameKanji;

        /** 画面パス. */
        private String value;

        /**
         * 設定値.
         * 
         * @return value
         */
        public String getValue() {
            return value;
        }

        /**
         * 日本語画面名.
         * 
         * @return viewNameKanji
         */
        public String getViewNameKanji() {
            return viewNameKanji;
        }
    }

    /**
     * <pre>
     * CsvFormat定数管理する定数クラス.
     * 
     *【変更履歴】
     * 1.00 2019/05/18 新規作成
     * </pre>
     * 
     * @author T.Yagi
     * @version 1.00
     */
    public enum CsvFormat {
        
        /** 全出力. */
        AllOutput("1", "全出力"),
        
        /** 会社毎営業活動合計. */
        CompanyMonthOutput("2", "会社毎営業活動合計");

        /** CSV出力ID. */
        private String outputId;

        /** CSV出力フォーマット名. */
        private String outputName;

        private CsvFormat(String outputId, String outputName) {
            this.outputId = outputId;
            this.outputName = outputName;
        }

        /**
         * CSV出力IDを取得.
         * 
         * @return outputId
         */
        public String getOutputId() {
            return outputId;
        }

        /**
         * CSV出力フォーマット名を取得.
         * 
         * @return outputName
         */
        public String getOutputName() {
            return outputName;
        }
    }

    /**
     * <pre>
     *  商材定数クラス
     *  
     * 【変更履歴】
     * 1.00 2019/06/01 新規作成
     * </pre>
     * 
     * @author T.Yagi
     * @version 1.00
     */
    public enum Commodity {
        
        /** SES. */
        SES("SES"),
        
        /** SES（海外）. */
        SES_OUTSIDE("SES（海外）"),
        
        /** SES（BP）. */
        SES_BP("SES（BP）"),
        
        /** 受託. */
        CONSIGNMENT("受託"),
        
        /** WEB制作. */
        CREATE_WEB("WEB制作"),
        
        /** オフショア. */
        OFFSHORE("オフショア"),
        
        /** ラボ. */
        LAB("ラボ"),
        
        /** 視察ツアー. */
        INSPECTION_TOUR("視察ツアー"),
        
        /** フォトレポ. */
        PHOTO_REPO("フォトレポ"),
        
        /** スマイルPOS. */
        SMILE_POS("スマイルPOS"),
        
        /** ペレット. */
        PELLET("ペレット"),
        
        /** スクール. */
        SCHOOL("スクール"),
        
        /** 採用関連. */
        RECRUITMENT_RELATED("採用関連");

        /** 選択肢. */
        private String value;

        public String getValue() {
            return value;
        }

        private Commodity(String value) {
            this.value = value;
        }
    }

    /**
     * <pre>
     * 区分の定数クラス.
     * 
     * 【変更履歴】
     * 1.00 2019/06/08 新規作成
     * </pre>
     * 
     * @author T.Yagi
     * @version 1.00
     */
    public enum SalesActivityKubun {
        
        /** 訪問. */
        VISIT("訪問"),
        
        /** 来社. */
        COMING_TO_WORK("来社"),
        
        /** 電話・メール. */
        TELEPHONE_EMAIL("電話・メール"),
        
        /** 交流会. */
        EXCHANGE_MEETING("交流会"),
        
        /** 面談. */
        INTERVIEW("面談"),
        
        /** リマインド. */
        REMIND("リマインド");

        /** 選択肢. */
        private String value;

        public String getValue() {
            return value;
        }

        private SalesActivityKubun(String value) {
            this.value = value;
        }
    }
    
    /**
     * <pre>
     * 五十音行の定数クラス.
     * 
     *【変更履歴】
     * 1.00 2019/06/15 新規作成
     * </pre>
     * 
     * @author T.Yagi
     * @version 1.00
     *
     */
    public enum GojuonGyo {
        
        /** 五十音行(ア). */
        A("ア"),
        
        /** 五十音行(カ). */
        KA("カ"),
        
        /** 五十音行(サ). */
        SA("サ"),
        
        /** 五十音行(タ). */
        TA("タ"),
        
        /** 五十音行(ナ). */
        NA("ナ"),
        
        /** 五十音行(ハ). */
        HA("ハ"),
        
        /** 五十音行(マ). */
        MA("マ"),
        
        /** 五十音行(ヤ). */
        YA("ヤ"),
        
        /** 五十音行(ラ). */
        RA("ラ"),
        
        /** 五十音行(ワ). */
        WA("ワ");
        
        /** 選択肢. */
        private String value;

        public String getValue() {
            return value;
        }

        private GojuonGyo(String value) {
            this.value = value;
        }

    }
}
