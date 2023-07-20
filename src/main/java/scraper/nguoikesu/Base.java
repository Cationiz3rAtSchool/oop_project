package scraper.nguoikesu;

import scraper.Page;

/**
 * Abstract package-visible base to provide a base url.
 */
abstract class Base extends Page {
	protected final static String baseUrl = "https://nguoikesu.com";

	protected Base(String url) { super(url); }
}
