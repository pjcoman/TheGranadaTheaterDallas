package comapps.com.thegranadatheaterdallas;


class Shows {

    private String actname = "";
    private String actstyle = "";
    private String actdescription = "";
    private String price = "";
    private String showdate = "";
    private String showtime = "";
    private String otheracts = "";
    private String wherefrom = "";
    private String showlink = "";
    private String actimagelink = "";
    private String actimagelink2 = "";
    private String otherinfo = "";


    public Shows() {
        // TODO Auto-generated constructor stub
    }

    public Shows(String actname, String actstyle, String actdescription, String price, String showdate, String showtime,
                 String otheracts, String otherinfo, String wherefrom, String showlink, String actimagelink, String actimagelink2) {
        super();
        this.actname = actname;
        this.actstyle = actstyle;
        this.actdescription = actdescription;
        this.price = price;
        this.showdate = showdate;
        this.showtime = showtime;
        this.wherefrom = wherefrom;
        this.otheracts = otheracts;
        this.showlink = showlink;
        this.actimagelink = actimagelink;
        this.actimagelink2 = actimagelink2;
        this.otherinfo = otherinfo;



    }


    public String getActName() {
        return actname;
    }

    public void setActName(String actname) {
        this.actname = actname;
    }

    public String getActStyle() {
        return actstyle;
    }

    public void setActStyle(String actstyle) {
        this.actstyle = actstyle;
    }

    public String getActDescription() {
        return actdescription;
    }

    public void setActDescription(String actdescription) {
        this.actdescription = actdescription;
    }

    public String getWhereFrom() {
        return wherefrom;
    }

    public void setWhereFrom(String wherefrom) {
        this.wherefrom = wherefrom;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

   public String getShowDate() {
        return showdate;
    }

    public void setShowDate(String showdate) {
        this.showdate = showdate;
    }


    public String getShowTime() {
        return showtime;
    }

    public void setShowTime(String showtime) {
        this.showtime = showtime;
    }

    public String getOtherActs() {
        return otheracts;
    }

    public void setOtherActs(String otheracts) {
        this.otheracts = otheracts;
    }

    public String getOtherInfo() {
        return otherinfo;
    }

    public void setOtherInfo(String otherinfo) {
        this.otherinfo = otherinfo;
    }

    public String getShowLink() {
        return showlink;
    }

    public void setShowLink(String showlink) {
        this.showlink = showlink;
    }


    public String getActImageLink() {
        return actimagelink;
    }

    public void setActImageLink(String actimagelink) {
        this.actimagelink = actimagelink;
    }

    public String getActImageLink2() {
        return actimagelink2;
    }

    public void setActImageLink2(String actimagelink2) {
        this.actimagelink2 = actimagelink2;
    }



}

