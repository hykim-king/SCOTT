/**
 * 
 */

let eUtil = {};

eUtil.ISEmpty = function(str){
	if(str != null && str != undefined){
		str = str.toString();
			
			if(str.replace(/ /gi, "").length == 0){
				return true; 
			}
	}
	return false;
}
