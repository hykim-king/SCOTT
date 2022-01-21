package kr.scott.ngg.cmn;

public class MessageVO extends DTO {

	/** 메세지 ID */
	private String msgId;
	/** 메세지 내용 */
	private String msgContent;

	public MessageVO() {
	}

	public MessageVO(String msgId, String msgContent) {
		this.msgId = msgId;
		this.msgContent = msgContent;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	@Override
	public String toString() {
		return "MessageVO [msgId=" + msgId + ", msgContent=" + msgContent + ", toString()=" + super.toString() + "]";
	}

}
