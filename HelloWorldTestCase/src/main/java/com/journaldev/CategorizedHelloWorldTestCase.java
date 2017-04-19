package com.journaldev;
 
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
 
import com.journaldev.categories.Mandatory;
import com.journaldev.categories.Optional;
 
@RunWith(Categories.class)
@IncludeCategory(Mandatory.class)
@ExcludeCategory(Optional.class)
@SuiteClasses({ParametrizedHelloWorldTestCase.class,HelloWorldTestCase.class})
public class CategorizedHelloWorldTestCase {
 
}