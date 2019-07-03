package com.xiaohu.demo.common;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static final String YYYY = "yyyy";
	public static final String YYYYMM = "yyyyMM";
	public static final String YYYY_MM = "yyyy-MM";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YYYY_MM_DD_ZH = "yyyy年MM月dd日";
	public static final String YYYYMMDD = "yyyyMMdd";
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static final String YYYYMMDDHHMMSSS = "yyyyMMddHHmmsss";
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYY_MM_DD_HH_CH = "yyyy年MM月dd日";
	public static final String YYYY_MM_DD_HH_CH_CM_CS = "yyyy年MM月dd日 HH时mm分ss秒";
	public static final String DD = "dd";
	public static final String MM = "MM";
	public  static final String MM_DD = "MM-dd";
	public  static final String HH_MM = "HH:mm";
	public  static final String YYYY_MM_DD_ZH_E = "yyyy年MM月dd日 E";

	/******************************************************************
	 * 获取指定格式化的时间字符串
	 * 
	 * @param type
	 * @return
	 */
	public static String getFormatDate(String date, String type) {

		if (Assert.hasTextNull(type)) {
			type = DateUtil.YYYY_MM_DD;
		}
		SimpleDateFormat format = new SimpleDateFormat(type);
		Date dateSet = null;
		try {
			dateSet = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return format.format(dateSet);
	}
	
	/******************************************************************
	 * 获取指定格式化的时间字符串
	 * 
	 * @param type
	 * @return
	 */
	public static String getFormatDate(String date, String dateType,String formatType) {

		if(Assert.hasTextNull(dateType)) {
			dateType = DateUtil.YYYY_MM_DD;
		}
		
		if(Assert.hasTextNull(formatType)) {
			formatType = DateUtil.YYYY_MM_DD;
		}
		
		SimpleDateFormat format1 = new SimpleDateFormat(dateType);
		SimpleDateFormat format2 = new SimpleDateFormat(formatType);
		Date dateSet = null;
		
		try {
			dateSet = format1.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return format2.format(dateSet);
	}

	/******************************************************************
	 * 获取指定格式化的时间字符串
	 * 
	 * @param type
	 * @return
	 */
	public static String getFormatDate(String type) {

		if (Assert.hasTextNull(type)) {
			type = DateUtil.YYYY_MM_DD;
		}
		SimpleDateFormat format = new SimpleDateFormat(type);
		return format.format(new Date());
	}
	
	/******************************************************************
	 * 获取当前时间
	 * @return java.sql.date
	 */
	public static java.sql.Date getcurrentDate() {
		
		return new java.sql.Date(DateUtil.getTimeInMillis());
	}

	/******************************************************************
	 * 获取当天是星期几
	 * 0-星期天；1-星期1；2-星期2;....
	 * @return
	 */
	public static int getWeek() {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
        
		int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if(day < 0) {
			day = 0;
		}
		
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
	}
	
	/******************************************************************
	 * 获取时间
	 * 
	 * @param type
	 *            时间格式
	 * @param dateStr
	 *            时间字符串
	 */
	public static Date getDate(String type, String dateStr) {

		Date returnDate = new Date();
		try {
			if (Assert.hasTextNull(type)) {
				type = DateUtil.YYYY_MM_DD;
			}
			returnDate = new SimpleDateFormat(type).parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return returnDate;
	}

	/******************************************************************
	 * 获取当前时间戳
	 * 
	 * @return
	 */
	public static Long getTimeInMillis() {

		return Calendar.getInstance().getTimeInMillis();
	}

	/*********************************************************************************
	 * 返回字符串,指定格式的日期
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String shortFmt(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/*********************************************************************************
	 * 返回字符串,指定格式的当前日期
	 * 
	 * @return
	 */
	public static String getDate() {
		return shortFmt(new Date(), YYYY_MM_DD);
	}

	public static String getDate(String format) {

		return shortFmt(new Date(), format);
	}

	/*********************************************************************************
	 * 返回字符串,yyyy-MM-dd，指定日期
	 * 
	 * @param date
	 * @return
	 */
	public static String dateFmt(Date date) {
		return shortFmt(date, YYYY_MM_DD);
	}

	/*********************************************************************************
	 * 获取指定日期的前interval天(interval 为负数) -1 前一天 或者后interval天(interval 为正数) 1 后一天
	 * 
	 * @param date
	 * @param interval
	 * @return
	 */
	public static String getBeforeOrAfterDate(Date date, int interval,
			String format) {
		Calendar currentTime = Calendar.getInstance();
		currentTime.setTime(date);
		currentTime.add(Calendar.DATE, interval);
		return shortFmt(currentTime.getTime(), format);
	}

	/*********************************************************************************
	 * 获取当前时间的上一天
	 * 
	 * @return
	 */
	public static String getYesterday() {
		return getBeforeOrAfterDate(new Date(), -1, YYYY_MM_DD);
	}

	public static String getYesterday_YYYYMMDD() {
		return getBeforeOrAfterDate(new Date(), -1, YYYYMMDD);
	}

	/*********************************************************************************
	 * 把java.sql.date 转换成java.util.date
	 */
	public static Date convertSqlDateToUtilDate(java.sql.Date sqlDate) {
		return new Date(sqlDate.getTime());
	}

	/*********************************************************************************
	 * 返回日期型，指定格式的日期
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date parse(String strDate, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		if (null != strDate && !"".equals(strDate)) {
			try {
				date = sdf.parse(strDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return date;
	}

	/*********************************************************************************
	 * 返回日期型，yyyy-MM-dd HH:mm:ss格式，指定日期
	 * 
	 * @param param
	 * @return
	 */
	public static Date parse(String param) {
		return parse(param, YYYY_MM_DD_HH_MM_SS);
	}

	/*********************************************************************************
	 * 返回日期型，yyyy-MM-dd格式，指定日期
	 * 
	 * @param param
	 * @return
	 */
	public static Date parseShort(String param) {
		return parse(param, YYYY_MM_DD);
	}

	/**********************************************************************************
	 * 把.util.date 转换成java.sql.date
	 */
	public static Date convertUtilDateToSqlDate(Date utilDate) {
		return new java.sql.Date(utilDate.getTime());
	}

	public static java.sql.Date parseDate(String param) {
		return parseSqlDate(param, YYYYMMDD);
	}

	public static Timestamp parseTime(String param) {
		return new Timestamp(parseSqlDate(param, YYYYMMDD).getTime());
	}

	/*********************************************************************************
	 * 
	 * @param strDate
	 * @param format
	 * @return
	 */
	public static java.sql.Date parseSqlDate(String strDate, String format) {
		return new java.sql.Date(parse(strDate, format).getTime());
	}

	/*********************************************************************************
	 * 返回某年某月的天数
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getDays(int year, int month) {
		int[] numberMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int numberOfMonth = numberMonth[month - 1];
		if (month == 2
				&& ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)))) {
			numberOfMonth++;
		}
		return numberOfMonth;
	}

	/*********************************************************************************
	 * 获取指定日期的年份
	 * 
	 * @param date
	 * @return
	 * @throws NumberFormatException
	 */
	public static int getYear(String date) throws NumberFormatException {
		String m = date.substring(0, 4);
		return Integer.parseInt(m);
	}

	/*********************************************************************************
	 * 获取指定日期的月份
	 * 
	 * @param date
	 * @return
	 * @throws NumberFormatException
	 */
	public static int getMonth(String date) throws NumberFormatException {
		String m = date.substring(date.indexOf("-") + 1, date.indexOf("-") + 3);
		return Integer.parseInt(m);
	}

	/*********************************************************************************
	 * 获取指定日期的天
	 * 
	 * @param date
	 * @return
	 * @throws NumberFormatException
	 */
	public static int getDay(String date) throws NumberFormatException {
		String m = date.substring(date.lastIndexOf("-") + 1);
		return Integer.parseInt(m);
	}

	/*********************************************************************************
	 * 获取指定两个时间段的天数
	 * 
	 * @param date
	 * @return
	 * @throws NumberFormatException
	 */
	public static int getDayNum(String dateBegin, String dateEnd)
			throws NumberFormatException {
		Long n = parseShort(dateEnd).getTime()
				- parseShort(dateBegin).getTime();
		int dayNum = (int) (n / (1000 * 60 * 60 * 24));
		return dayNum;
	}

	/*********************************************************************************
	 * 获取指定两个时间段的天数
	 * 
	 * @return
	 * @throws NumberFormatException
	 */
	public static int getDayNum(Date beginDate, Date endDate) {

		return (int) ((endDate.getTime() - beginDate.getTime()) / (1000 * 60 * 60 * 24));
	}

	/*********************************************************************************
	 * 获取当天时间
	 * 
	 * @return
	 */
	public static String getNowTime() {
		Date now = new Date();
		// 可以方便地修改日期格式
		SimpleDateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD);
		String hehe = dateFormat.format(now);
		return hehe;
	}

	/*********************************************************************************
	 * 获取指定两个时间段的天数
	 * 
	 * @param date
	 * @return
	 * @throws NumberFormatException
	 */
	public static int getDayNumValue(String dateBegin, String dateEnd)
			throws NumberFormatException {
		Long n = parseDate(dateEnd).getTime() - parseDate(dateBegin).getTime();
		int dayNum = (int) (n / (1000 * 60 * 60 * 24));
		return dayNum;
	}

	/*********************************************************************************
	 * 返回两日期间隔天数
	 * 
	 * @param begin
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	public static long getDiffDays(String begin, String end)
			throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		long head = df.parse(begin).getTime();
		long tail = df.parse(end).getTime();
		long days = (tail - head) / (1000 * 60 * 60 * 24);
		return days;
	}

	/*********************************************************************************
	 * @see 得到当前时刻的时间字符串
	 * @return String para的标准时间格式的串,例如：返回'2011-08-09 16:00:00'
	 */
	public static Timestamp getTimestamp() {
		Timestamp ret = null;
		try {
			Date currentDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String date = dateFormat.format(currentDate);
			Date nowdate = dateFormat.parse(date);
			long datelong = nowdate.getTime();
			ret = new Timestamp(datelong);
		} catch (Exception e) {
		}
		return ret;
	}

	public static String getTimestampStr(Timestamp ts) {
		String tsStr = "";
		if (ts != null) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				tsStr = dateFormat.format(new Date(ts.getTime()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return tsStr;
	}

	/*********************************************************************************
	 * 
	 * @param currentDate
	 *            当前日期
	 * @return 前或后几天的日期
	 */
	public static java.sql.Date getBeforeOrAfterDate(java.sql.Date currentDate,
			int interval) {
		Calendar currentTime = Calendar.getInstance();
		currentTime.setTime(new Date(currentDate.getTime()));
		currentTime.add(Calendar.DATE, interval);

		Date afterUtilDate = currentTime.getTime();
		return new java.sql.Date(afterUtilDate.getTime());
	}

	/****************************************************************************
	 * 获取当前日期对应的前几个月或者或几个月的日期
	 * 
	 * @param month
	 *            正数表示后面，负数表示前面
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static String getCurrentBeforeDateString(int month, String format) {

		SimpleDateFormat matter = new SimpleDateFormat(format);

		Calendar calendar = Calendar.getInstance();
		
		// 将calendar装换为Date类型
		calendar.add(Calendar.MONTH, month);

		Date date02 = calendar.getTime();

		return matter.format(date02);
	}
	
	
	/****************************************************************************
	 * 获取【指定】日期对应的前几个月或者或几个月的日期
	 * 
	 * @param dataStr 时间  格式：yyyy-MM-dd
	 * @param month
	 *            正数表示后面，负数表示前面
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static String getMonthBeforeDateString(String dateStr,int month, String format) {

		SimpleDateFormat matter = new SimpleDateFormat(format);

		Calendar calendar = Calendar.getInstance();
		
		try {
			calendar.setTime(new SimpleDateFormat(DateUtil.YYYY_MM_DD).parse(dateStr));
			calendar.add(Calendar.MONTH, month);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return matter.format(calendar.getTime());
	}
	
	
	/****************************************************************************
	 * 获取【指定】日期对应的前几天或者后几天的时间字符串
	 * 
	 * @param dataStr 时间  格式：yyyy-MM-dd
	 * @param month
	 *            正数表示后面，负数表示前面
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static String geDayhBeforeDateString(String dateStr,int day, String format) {

		SimpleDateFormat matter = new SimpleDateFormat(format);

		Calendar calendar = Calendar.getInstance();
		
		try {
			calendar.setTime(new SimpleDateFormat(format).parse(dateStr));
			calendar.add(Calendar.DATE, day);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return matter.format(calendar.getTime());
	}
	
	/****************************************************************************
	 * 获取当前日期对应的前几个月或者或几个月的日期
	 * 
	 * @param month
	 *            正数表示后面，负数表示前面
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static java.sql.Date getCurrentBeforeDate(int month) {

		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.MONTH, month);

		Date date = calendar.getTime();

		return new java.sql.Date(date.getTime());
	}

	/****************************************************************************
	 * 获取当前日期指定的前后天数对应的日期
	 * 
	 * @param day
	 * @param formatType
	 * @return
	 */
	public static String getCurrentBeforeDateByDay(int day, String formatType) {

		SimpleDateFormat format = new SimpleDateFormat(formatType);
		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DATE, day);

		Date date2 = calendar.getTime();

		return format.format(date2);
	}
	
	
	/****************************************************************************
	 * 获取当前日期指定的分钟对应的日期字符串
	 * 
	 * @param day
	 * @param formatType
	 * @return
	 */
	public static String getCurrentBeforeDateByMinute(int minute, String formatType) {

		SimpleDateFormat format = new SimpleDateFormat(formatType);
		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.MINUTE, minute);

		Date date2 = calendar.getTime();

		return format.format(date2);
	}
	
	/****************************************************************************
	 * 获取当前日期指定的分钟对应的日期
	 * @param day
	 * @return
	 */
	public static Date getCurrentBeforeDateByMinute(int minute) {

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, minute);

		return calendar.getTime();
	}

	/***************************************************************************
	 * 
	 * 当前时间和指定的时间比较，如果当前时间小于指定的时间 则返回当天指定的时间，不然后返回指定时间的后一天。
	 * 
	 * @param hhmmss
	 *            指定的时间-格式为：HH:mm:ss
	 * @param hhmmss
	 *            任务执行的起始时间
	 * @return
	 */
	public static Date getTagDate(String hh_mm_ss) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();

		Date date = calendar.getTime();

		String dateTagStr = dateFormat.format(date) + " " + hh_mm_ss;
		int flag = dateTagStr.compareTo(format.format(date));
		Date dateTag = null;

		try {

			if (flag < 1) {
				calendar.add(Calendar.DATE, 1);
				dateTagStr = dateFormat.format(calendar.getTime()) + " "
						+ hh_mm_ss;
				dateTag = format.parse(dateTagStr);
			} else {
				dateTag = format.parse(dateTagStr);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dateTag;
	}
	
	
	/***************************************************************************
	 * 获取两个时间相差月份数
	 * @param date1 <String>
	 * @param date2 <String>
	 * @return int
	 * @throws ParseException
	 */
	public static int getMonthSpace(String date1, String date2) {

		int result = 0;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();

			c1.setTime(sdf.parse(date1));
			c2.setTime(sdf.parse(date2));

			result = c2.get(Calendar.MONDAY) - c1.get(Calendar.MONTH);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return result == 0 ? 1 : Math.abs(result);

	}
	
	/***************************************************************
	 * 由出生日期获得年龄 
	 * @param birthDay
	 * @return
	 * @throws Exception
	 */
    public static int getAge(Date birthDay) {
    	
        Calendar cal = Calendar.getInstance();  
  
        if (cal.before(birthDay)) {  
            throw new IllegalArgumentException("出生年月不能小于当前时间!");  
        }  
        int yearNow = cal.get(Calendar.YEAR);  
        int monthNow = cal.get(Calendar.MONTH);  
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);  
        cal.setTime(birthDay);  
  
        int yearBirth = cal.get(Calendar.YEAR);  
        int monthBirth = cal.get(Calendar.MONTH);  
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);  
  
        int age = yearNow - yearBirth;  
  
        if (monthNow <= monthBirth) {  
            if (monthNow == monthBirth) {  
                if (dayOfMonthNow < dayOfMonthBirth) age--;  
            }else{  
                age--;  
            }  
        }  
        
        return age;  
    }
    
    
    /***************************************************************
     * 获取当前日期对应的前几周周一对应的时间
     * @param week
     * @return
     */
    public static String getMondayDate(int week) {
    	
    	int day = DateUtil.getWeek();
		if(day == 0) {
			return DateUtil.getCurrentBeforeDateByDay(-(6+week*7), DateUtil.YYYY_MM_DD);
		} else {
			return DateUtil.getCurrentBeforeDateByDay(-(DateUtil.getWeek() - 1+week*7), DateUtil.YYYY_MM_DD);
		}
    }
    
    
    /***************************************************************
     * 获取某年某周的起始时间和结束时间
     * 
     * @param year
     * @param weekindex
     * @return
     */
    public static String[] getDayOfWeek(int year, int weekindex) {
    	
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setWeekDate(year, weekindex, 1);
 
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 2;
        c.add(Calendar.DATE, -dayOfWeek); // 得到本周的第一天
        String begin = sdf.format(c.getTime());
        c.add(Calendar.DATE, 6); // 得到本周的最后一天
        String end = sdf.format(c.getTime());
        String[] range = new String[2];
        
        range[0] = begin;
        range[1] = end;
        
        return range;
    }
	
	public static void main(String[] args) {
		
		/*
		System.out.println(DateUtil.getMonthBeforeDateString("2015-09-01", 5, DateUtil.YYYY_MM_DD));
		
		System.out.println(getMonthSpace("2015-08-23", "2016-01-27"));
		
		System.out.println("07".compareTo("04"));
		 SimpleDateFormat sdf1 =   new SimpleDateFormat( "yyyy年MM月dd日HH时mm分ss秒");
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        //String str = sdf.format(new Date("2016-02-01"));
	        try {
	        	System.out.println(sdf1.format(sdf.parse("2016-02-01 15:20:45"))); 
			} catch (ParseException e) {
				e.printStackTrace();
			}
	        
	        System.out.println(DateUtil.getWeek());
	        
	        System.out.println(DateUtil.getCurrentBeforeDateByDay(-(DateUtil.getWeek() - 1), DateUtil.YYYY_MM_DD));
	        
	        System.out.println(DateUtil.getDay(DateUtil.getDate()));
	        
	        System.out.println(DateUtil.getCurrentBeforeDateByDay(-(DateUtil.getDay(DateUtil.getDate())-1), DateUtil.YYYY_MM_DD));
	        
	        System.out.println(getCurrentBeforeDateByMinute(100, DateUtil.YYYY_MM_DD_HH_MM_SS));
	        
	        System.out.println(getMondayDate(1));
		
			System.out.println(geDayhBeforeDateString("2017-07-24", 7, DateUtil.YYYY_MM_DD));
	        
        */
		
		String[] dates = getDayOfWeek(2017, 31);
		System.out.println(dates[0] + " | " + dates[1]);
		
		//String ss = "yyyyMMddHHmmsss";
		//System.out.println(DateUtil.getDate(ss));
		
	}
}
