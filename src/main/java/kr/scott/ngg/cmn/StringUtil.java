package kr.scott.ngg.cmn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class StringUtil {
	
	
	
	public static String getRenameFile(String format) {
		return getFormatDate(format)+getUUID();
	}
	
	
	/**
	 * 필수 입력 항목 null 체크 
	 * 입력한 객체가 null이거나 ""일 경우 msgId: "30", msgContent: valueName은 필수 항목입니다. 반환
	 * 아니면 null 반환
	 * 
	 * @param value 체크할 항목 객체
	 * @param valueName 에러시 표시할 이름
	 * @return MessageVO
	 */
	public static MessageVO checkRequiredValue(String value, String valueName) {
		return (value == null || value.equals(""))? new MessageVO("30", "필수 입력 항목 누락: ["+valueName+"]"): null;
	}
	
	/**
	 * 32bit UUID 생성
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 현재날짜 기준 dateFormat을 return
	 * default "yyyyMMdd"
	 * @param dateFormat
	 * @return
	 */
	public static String getFormatDate(String dateFormat) {
		if(dateFormat==null || dateFormat.equals("")) {
			dateFormat = "yyyyMMdd";
		}
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(date);
	}

	/**
	 * 원본 String이 null이면 defaultStr로 치환
	 * @param strTarget
	 * @param defaultStr
	 * @return
	 */
	public static String nvl(String strTarget, String defaultStr) {
		if(strTarget == null || strTarget.equals("")) {
			return defaultStr;
		}
		return strTarget;
	}

	/**
	 * 원본 String이 null이면 ""로 치환
	 * @param strTarget
	 * @return
	 */
	public static String nvl(String strTarget) {
		return nvl(strTarget, "");
	}

	/**
	 * Paging
	 * @param totalNum : 게시글 총 건수
	 * @param currPage : 현재 페이지 번호
	 * @param rowPage : 한 페이지에 보여질 행 수
	 * @param bottomPage : 바닥에 보여줄 페이지
	 * @param callUrl : 호출 URL
	 * @param funcName : 호출 자바스크립트
	 * @return String(html)
	 */
	public static String renderPaging(int totalNum, int currPage, int rowPage, int bottomPage, String callUrl, String funcName) {
		StringBuilder html = new StringBuilder(2000);
		
		int maxNum = totalNum; // 게시글 총 건수
		int currPageNo = currPage; // 현재 페이지 번호
		int rowPerPage = rowPage; // 한 페이지에 보여질 행 수
		int bottomCount = bottomPage; // 바닥에 보여줄 페이지
		String url = callUrl;
		String scriptName = funcName;
		
		int maxPageNo = ((maxNum-1)/rowPerPage)+1; 
		int startPageNo = ((currPageNo-1)/bottomCount)*bottomCount+1;
		int endPageNo = ((currPageNo-1)/bottomCount+1)*bottomCount;
		
		int nowBlockNo = ((currPageNo-1)/bottomCount)+1;
		int maxBlockNo = ((maxNum-1)/bottomCount)+1;
		
		// for 반복변수
		int idx = 0;
		
		if(currPageNo > maxPageNo) {
			return "";
		}
		
		html.append("<table id=\"paging\">	\n");
        html.append("	<tr>																					\n");
        html.append("		<td align=\"center\">																\n");
        html.append("			<ul>																			\n");
       
        // 맨 앞 페이지로 이동
        if(nowBlockNo>1 && nowBlockNo<=maxBlockNo) {
        	html.append("			<li><a href=\"javascript:"+scriptName+"('"+url+"', 1);\">&laquo;</a></li>		\n");
        }
        
        // 이전 블록으로 이동
        if(startPageNo>bottomCount) {
        	html.append("			<li><a href=\"javascript:"+scriptName+"('"+url+"', "+(startPageNo-1)+");\">&lt;</a></li>	\n");
        }
        
        // 번호
        for(idx=startPageNo; idx<=maxPageNo && idx<=endPageNo; idx++) {
        	if(idx == currPageNo) {
        		html.append("		<li><a>"+idx+"</a></li>	\n");
        	} else {
        		html.append("		<li><a href=\"javascript:"+scriptName+"('"+url+"', "+idx+");\">"+idx+"</a></li>	\n");
        	}
        }
    
        // 다음 블록으로 이동
        if(maxPageNo>=idx) {
        	html.append("			<li><a href=\"javascript:"+scriptName+"('"+url+"', "+((nowBlockNo*bottomCount)+1)+");\">&gt;</a></li>		\n");
        	// 맨 뒤 페이지로 이동
        	html.append("			<li><a href=\"javascript:"+scriptName+"('"+url+"', "+(maxPageNo)+");\">&raquo;</a></li>		\n");
        }
        
        html.append("			</ul>																			\n");
        html.append("		</td>																				\n");
        html.append("	</tr>																					\n");
        html.append("</table>																					\n");
        
        
		return html.toString();
	}
	
	
}//--class
