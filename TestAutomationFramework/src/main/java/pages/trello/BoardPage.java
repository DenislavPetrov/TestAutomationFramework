package pages.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;

public class BoardPage extends BaseTrelloPage {

    public BoardPage(WebDriver driver) {
        super(driver, "trello.boardPage");
    }

    public void addCardToList(String cardName) {
        String cartName = getUIMappingByKey("This is my first Trello Card");

        actions.waitForElementClickable("trello.recently.viewed.boards.menu");
        actions.clickElement("trello.recently.viewed.boards.menu");

        actions.waitForElementClickable("trello.menu.popover.board.tile");
        actions.clickElement("trello.menu.popover.board.tile");

        actions.waitForElementClickable("trello.header.create.CreateCard");
        actions.clickElement("trello.header.create.CreateCard");

        actions.waitForElementClickable("trello.createCard.titleInput");
        actions.typeValueInField(cartName, "trello.createCard.titleInput");

        actions.waitForElementClickable("trello.create.card.submitButton");
        actions.clickElement("trello.create.card.submitButton");
    }

    public void assertListExists(String listName) {
        actions.waitForElementPresent("trello.boardPage.listByName", listName);
    }

    public void assertAddListExists() {
        actions.waitForElementPresent("trello.boardPage.listWrapper");
    }
    public void assertCardExists(String cardName) {
        actions.waitForElementPresent("trello.boardPage.cardByName", cardName);
    }

    public void assertBoardIsNotEmpty(String boardName) {
        actions.waitForElementClickable("trello.boardPage.RecentProject");
        actions.clickElement("trello.boardPage.RecentProject");
        actions.waitForElementPresent("trello.header.create.ProjectView", boardName);
    }
    public void assertBoardIsEmpty() {
        actions.waitForElementVisible("//span[@data-testid='BoardIcon']");
        actions.clickElement("//span[@data-testid='BoardIcon']");
        actions.waitForElementVisible("//div[@data-testid='boards-list-empty-state']");
        actions.clickElement("//div[@data-testid='boards-list-empty-state']");

    }
}
