package vogella.tutorial;

public class ArticleManager {
	ArticleCalculator calculator;
	ArticleDatabase database;
	   ArticleManager(ArticleCalculator calculator, ArticleDatabase database) {
	    this.calculator = calculator;
	    this.database = database;
	   }

	public void initialize() {
		database.addListener(new ArticleListener());
		
	}
}
