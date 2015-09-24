package example.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import example.models.Quote;

public interface QuoteService {

	public Quote getQuoteById(Long id);

	@Component
	public static class QuoteServiceImpl implements QuoteService {

		private static final Logger log = LoggerFactory.getLogger(QuoteServiceImpl.class);

		@Override
		@Cacheable("quotes")
		public Quote getQuoteById(Long id) {
			log.info("Actually fetching quote now for id=" + id);

			RestTemplate restTemplate = new RestTemplate();
			Quote quote = restTemplate.getForObject(
					"http://gturnquist-quoters.cfapps.io/api/random",
					Quote.class);
			quote.getValue().setId(id);

			return quote;
		}
	}
}
