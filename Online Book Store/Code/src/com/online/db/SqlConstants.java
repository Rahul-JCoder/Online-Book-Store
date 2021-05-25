package com.online.db;

public class SqlConstants {

	public static final String _SEARCH_BY_TITLE = "select * from bookdescriptions where soundex(title)=soundex(?)";
	public static final String _GET_AUTHOR = "select fname from bookauthors where authorid=(select authorid from bookauthorsbooks where isbn=?)";
	public static final String _SEARCH_BY_AUTHOR = "select * from bookdescriptions where isbn=?";
	public static final String _GET_ISBN = "select a.isbn,b.fname from bookauthors b,bookauthorsbooks a  where upper(b.fname)=upper(?) and b.AUTHORID=a.AUTHORID";
	public static final String _GET_CATEGORIES = "select * from bookcategories";
	public static final String _GET_ISBN1 = "select bc.isbn from bookcategoriesbooks bc,bookcategories b where bc.CATEGORYID=? and b.CATEGORYID=bc.CATEGORYID";
	public static final String _SEARCH_BY_CATEGORY = "select b.*,ba.fname from bookdescriptions b,bookauthors ba,bookauthorsbooks bas where b.isbn=? and bas.ISBN=b.ISBN and bas.AUTHORID=ba.AUTHORID";
	public static final String _SEARCH_BY_PRICE = "select b.*,ba.fname from bookdescriptions b,bookauthors ba,bookauthorsbooks bas where b.PRICE between ? and ? and bas.ISBN=b.ISBN and bas.AUTHORID=ba.AUTHORID";
	public static final String _GET_LOGINTYPE = "select userid,role from userdetails where loginid=? and password=?";
	public static final String _ADD_CATEGORY = "insert into bookcategories values((select nvl(max(categoryid),1000)+1 from bookcategories),?)";
	public static final String _ADD_BOOK_INFO = "insert into bookdescriptions values(?,?,?,?,?,sysdate,?,?,?,?,?)";
	public static final String _ADD_AUTHOR = "insert into bookauthors values((select nvl(max(authorid),1000)+1 from bookauthors),?)";
	public static final String _ADD_BOOK_AUTHORS = "insert into bookauthorsbooks values(?,(select max(authorid) from bookauthors))";
	public static final String _ADD_BOOK_CATEGORIES = "insert into bookcategoriesbooks values(?,?)";
	public static final String _REGISTER = "insert into userdetails values((select nvl(max(userid),1000)+1 from userdetails),?,?,?,to_date(?,'dd-mm-yyyy'),?,?,?,?,?,?)";
	public static final String _ADDRESS ="insert into address values((select nvl(max(addressid),1000)+1 from address),(select max(userid) from userdetails),?,?,?,?,?,?)";
	public static final String _ADD_TO_CART = "insert into bookorders(orderid,bookid,price,userid,status) values((select nvl(max(orderid),1000)+1 from bookorders),?,?,?,'pending')";
	public static final String _COUNT = "select count(*) from bookorders where userid=?";
	public static final String _VIEW_CART = "select orderid,bookid,quantity,price from bookorders where userid=? and status='pending'";
	public static final String _VIEW_QUANTITY = "select quantity from bookdescriptions where isbn=?";
	public static final String _PLACE_ORDER = "insert into totalorders values((select nvl(max(orderid),1000)+1 from totalorders),?,sysdate,?,'pending')";
	public static final String _UPDATE_STATUS = "update bookorders set status='completed' where userid=?";
	public static final String _DELETE_CART_ITEM = "delete bookorders where orderid=?";
	public static final String _VIEW_CUSTOMER_ORDERS = "select * from totalorders where status='pending'";
	public static final String _ACCEPT_ORDER = "update totalorders set status='accepted' where orderid=? and status='pending'";
	public static final String _REJECT_ORDER = "update totalorders set status='rejected' where orderid=? and status='pending'";
	public static final String _VIEW_ORDER_STATUS = "select * from totalorders where userid=?";
	public static final String _POST = "insert into editorials values(?,?)";
	public static final String _VIEW_EDITORIALS = "select isbn,opnion from editorials where isbn=?";
	public static final String _RECOVER_PASSWORD = "select password from userdetails where squestion=? and loginid=? and answer=?";
	public static final String _CHANGE_PASSWORD = "update userdetails set password=? where loginid=? and password=?";
	public static final String _VIEW_PROFILE = "select u.loginid,u.password,u.email,u.dob,u.phone,u.squestion,u.answer,u.fullname,u.gender,a.houseno,a.street,a.city,a.state,a.country,a.pinnumber from userdetails u, address a where u.userid=? and u.userid=a.userid";
	public static final String _VIEW_USERS = "select u.loginid,u.password,u.email,u.dob,u.phone,u.squestion,u.answer,u.fullname,u.gender,a.houseno,a.street,a.city,a.state,a.country,a.pinnumber from userdetails u, address a where u.role!='admin' and u.userid=a.userid";
	public static final String _VIEW_BOOKS  ="select * from bookdescriptions";
	public static final String _VIEW_BOOKS1  ="select * from bookdescriptions";
	public static final String  _DELETE_BOOK2=" delete from bookdescriptions where isbn=?";
	public static final String  _DELETE_BOOK1=" delete from BOOKAUTHORSBOOKS where isbn=?";
	public static final String  _DELETE_BOOK=" delete from BOOKCATEGORIESBOOKS where isbn=?";
	public static final String  _DISPLAY_BOOKS="select isbn,title,description,price,publisher from bookdescriptions where isbn=?";
	
	
	
	
}
