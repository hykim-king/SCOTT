package kr.scott.ngg.cmn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class DummyMailSender implements MailSender {
	final Logger LOG = LogManager.getLogger(getClass());

	public DummyMailSender() {
	}

	public void send(SimpleMailMessage simpleMessage) throws MailException {
		LOG.debug("================= Dummy Send");
		LOG.debug("개발용) 실제 메일 전송하지 않음");

	}

	public void send(SimpleMailMessage... simpleMessages) throws MailException {
		LOG.debug("================= Dummy Send");
		LOG.debug("개발용) 실제 메일 전송하지 않음");

	}

}
