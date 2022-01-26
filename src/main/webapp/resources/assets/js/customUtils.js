
// Ajax
let ajaxHelper = {
    /**  
     * <pre>
     * Ajax Wrapper
     * 필수) _URL - 전송 URL (String)
     * 필수) _PARAMETERS - 전송 파라미터 (object or String)
     * 필수) _METHOD - 전송 방식 (Http Method)
     * 필수) _CALLBACK - 콜백함수 (function)
     * 
     * 선택) _async - 동기화 여부 (boolean : 미지정시 true)
     * 선택) _errorMsg - 전송 실패시 메시지 (String)
     * </pre>
     */
    callAjax : function(_URL, _PARAMETERS, _METHOD, _ASYNC_STATUS, _CALLBACK){
        if(_URL != null){
 
            let _async = _ASYNC_STATUS;
            if(_async == null) _async = true;
 
            let _errorMsg = "서버에 요청중 문제가 발생!!";
             
            console.log("=callAjax========================="); 
            console.log("_URL:"+_URL);
            console.log("_PARAMETERS:"+_PARAMETERS);
            
			let _paramArray = Object.keys(_PARAMETERS);//param key목록
            if(_paramArray.length>0){
	            for(let i=1;i<_paramArray.length;i++){
	            	console.log(_paramArray[i]+":"+_PARAMETERS[_paramArray[i]]);
	            }
            }   
            console.log("_METHOD:"+_METHOD);
            console.log("_ASYNC_STATUS:"+_ASYNC_STATUS);
            console.log("=callAjax=========================");
            
            $.ajax({
	            url     : _URL,
                type    : _METHOD,
                data    : _PARAMETERS,
                async   : _async,
                success : function(res){
                	$(':focus').blur();  
                    _CALLBACK(res);
                },
                error   : function(xhr,status,err){
                
                    console.log("_errorMsg:"+xhr.status);
                    if(xhr.status == 400){
                         window.location.href = "/ngg/cmn/nullPointerException";
                    }else if(xhr.status == 500){
                         window.location.href = "/ngg/cmn/error";
                    }else if(_errorMsg != null){
                        alert(_errorMsg);
                    }else{
                        alert("서버에 요청중 문제가 발생했습니다.\n작성하신 내용이 저장되지 않았습니다.\n오류가 지속되면 관리자에게 문의해주세요.");
                    }
                }
            });
            
        } else {
            alert("잘못된 요청입니다.");
            return false;
        }
    }
};


// Empty Check
let emptyChecker = {};

emptyChecker.isEmpty = function(str){
	if(str != null && str != undefined) {
		str = str.toString();
		
		if(str.replace(/ /gi, "").length == 0) return true;
	}
	return false;
};


