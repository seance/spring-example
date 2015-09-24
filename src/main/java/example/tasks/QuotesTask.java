package example.tasks;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import example.models.Quote;
import example.services.QuoteService;

@Component
public class QuotesTask {

	private static final Logger log = LoggerFactory.getLogger(QuotesTask.class);

	@Autowired
	private QuoteService quoteService;

	private AtomicLong quoteIds = new AtomicLong(0);

	@Scheduled(fixedRate = 10000)
	public void queryQuote() {
		Quote quote = quoteService.getQuoteById(quoteIds.getAndIncrement());
		log.info(quote.toString());
	}
}
