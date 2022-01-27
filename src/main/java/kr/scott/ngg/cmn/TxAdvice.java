package kr.scott.ngg.cmn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class TxAdvice {
	final Logger LOG = LogManager.getLogger(getClass());

	PlatformTransactionManager transactionManager;

	public TxAdvice() {
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public Object transactionAdvice(ProceedingJoinPoint pjp) throws Throwable {
		LOG.debug("= = = TxAdvice = = =");
		
		Object ret = null;
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

		try {
			ret = pjp.proceed();
			transactionManager.commit(status);
			LOG.debug("TxAdvice -------- commit");
		} catch (Exception e) {
			LOG.debug("TxAdvice -------- rollback");
			transactionManager.rollback(status);
		}
		
		return ret;
	}
}
