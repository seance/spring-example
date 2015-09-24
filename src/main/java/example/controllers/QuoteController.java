package example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.models.Quote;
import example.services.QuoteService;

@RestController
public class QuoteController {
	
	private static final Logger log = LoggerFactory.getLogger(QuoteController.class);

	@Autowired
	private QuoteService quoteService;
	
	@RequestMapping("/quotes/{id}")
	public Quote getQuote(@PathVariable("id") Long id) {
		log.info("Servicing REST API request for quote id=" + id);
		return quoteService.getQuoteById(id);
	}
}
