/**
 * 
 */
function myFormatDate(strtime) {
	var arrtime = strtime.split(" ");
	var year = arrtime[5]
	var strmonth = arrtime[1];
	var month = "";
	switch(strmonth){
	case 'Jan':
		month = "01";
		break;
	case 'Feb':
		month = "02";
		break;
	case 'Mar':
		month = "03";
		break;
	case 'Apr':
		month = "04";
		break;
	case 'May':
		month = "05";
		break;
	case 'Jun':
		month = "06";
		break;
	case 'Jul':
		month = "07";
		break;
	case 'Aug':
		month = "08";
		break;
	case 'Sep':
		month = "09";
		break;
	case 'Oct':
		month = "10";
		break;
	case 'Nov':
		month = "11";
		break;
	case 'Dec':
		month = "12";
		break;
	}
	var day = arrtime[2];
 	var time = year+"-"+month+"-"+day;
 	return time;
}