package com.db.am.bauhaus.project.steplib;

import com.db.am.bauhaus.project.SessionVar;
import com.db.am.bauhaus.project.pages.MainSearchPage;
import com.db.config.SerenityFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.everyItem;

/**
 * Created by ongshir on 05/10/2016.
 */
public class SearchUser extends ScenarioSteps {

    MainSearchPage mainSearchPage;

    String searchText = "craft";

    @Step
    public void search_from_input_box() {
        mainSearchPage.searchFromInputBox(searchText);
    }

    @Step
    public void verify_result_for_top_categories() {
        assertThat(mainSearchPage.getTopCategoriesHeader(), containsString(searchText));
    }

    @Step
    public void verify_result_for_all_categories() {
        assertThat(mainSearchPage.getAllCategoriesHeader(), containsString(searchText));
    }

    @Step
    public void search_from_drop_down() {
        SerenityFacade.setData(SessionVar.SEARCH_RESULT_BREAD_CRUMB, "Anklets");
        mainSearchPage.searchFromDropDownMenu();
    }

    public void search_from_category_icon() {
        SerenityFacade.setData(SessionVar.SEARCH_RESULT_BREAD_CRUMB,mainSearchPage.getSearchCategoryName());
        mainSearchPage.searchFromCategoryIcon();
    }

    @Step
    public void verify_search_drop_down_menu_result_bread_crumb() {
        assertThat(mainSearchPage.getDropDownResultTopCategoriesHeader(), containsString(SerenityFacade.getData(SessionVar.SEARCH_RESULT_BREAD_CRUMB)));
    }

    @Step
    public void set_Search_Text_In_Input_Box(String searchText){
        mainSearchPage.setSearchTextInInputBox(searchText);
    }

    @Step
    public void get_Search_Suggestions_From_Search_Input_Box(String expectedSearchText){
        List<String> searchSuggestionsList = mainSearchPage.getSearchSuggestionsList();
        assertThat(searchSuggestionsList,everyItem(containsString(expectedSearchText)));
    }
}
