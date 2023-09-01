package pages.trello;

import org.openqa.selenium.WebDriver;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;

public class BoardsPage extends BaseTrelloPage {

    public BoardsPage(WebDriver driver) {
        super(driver, "trello.boardsPage");
    }

    public void createBoard() {

        String boardName = getUIMappingByKey("trello.boardName");

        actions.waitForElementClickable("trello.header.create.menuButton");
        actions.clickElement("trello.header.create.menuButton");

        actions.waitForElementClickable("trello.header.createBoard.dropDownButton");
        actions.clickElement("trello.header.createBoard.dropDownButton");

        actions.waitForElementClickable("trello.createBoard.titleInput");
        actions.typeValueInField(boardName, "trello.createBoard.titleInput");

        actions.waitForElementClickable("trello.create.board.submitButton");
        actions.clickElement("trello.create.board.submitButton");
    }

    public void clickOnBoard(String boardName) {
        actions.waitForElementVisible("trello.boardsPage.boardByTeamAndName", boardName);
        actions.clickElement("trello.boardsPage.boardByTeamAndName", boardName);
    }
    public void moveCardToList() {
        String moveThisCardLocator = "//a[@class='list-card js-member-droppable ui-droppable']";
        String toThisPlaceLocator = "(//div[@data-testid='list-header'])[2]";

        actions.waitForElementPresent("//a[@class='list-card js-member-droppable ui-droppable']");
        actions.waitForElementPresent("(//div[@data-testid='list-header'])[2]");

        actions.dragAndDropElement(moveThisCardLocator, toThisPlaceLocator);
    }
    public void deleteBoard() {

        actions.waitForElementClickable("//button[@aria-label='Show menu']");
        actions.clickElement("//button[@aria-label='Show menu']");

        actions.waitForElementClickable("//span[@class='icon-sm icon-remove board-menu-navigation-item-link-icon']");
        actions.clickElement("//span[@class='icon-sm icon-remove board-menu-navigation-item-link-icon']");

        actions.waitForElementClickable("//input[@type='submit' and @value='Close']");
        actions.clickElement("//input[@type='submit' and @value='Close']");
    }
    public void addNewList(String listName) {

        actions.waitForElementClickable("//input[@class='list-name-input']");
        actions.typeValueInField(listName, "//input[@class='list-name-input']");

        actions.waitForElementClickable("//input[@type='submit' and @value='Add list']");
        actions.clickElement("//input[@type='submit' and @value='Add list']");
    }
}
