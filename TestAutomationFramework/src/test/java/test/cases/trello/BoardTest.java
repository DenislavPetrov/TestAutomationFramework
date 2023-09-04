package test.cases.trello;

import org.junit.*;
import pages.trello.BoardPage;
import pages.trello.BoardsPage;


public class BoardTest extends BaseTest {
    @Before
    public void beforeTests() {
        login();
    }

    @Test
    public void createBoardWhenCreateBoardClicked() {

        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.createBoard();
        boardsPage.addNewList("TODO");
        boardsPage.addNewList("DOING");
        boardsPage.addNewList("DONE");

        BoardPage boardPage = new BoardPage(actions.getDriver());

        boardPage.assertListExists("TODO");
        boardPage.assertBoardIsNotEmpty("trello.boardName");
    }

    @Test
    public void createNewCardInExistingBoardWhenCreateCardClicked() {

        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.clickOnBoard("My First Board");

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.addCardToList("trello.cardName");
        boardPage.assertCardExists("trello.cardName");
        boardPage.assertAddListExists();
    }

    @Test
    public void moveCardBetweenStatesWhenDragAndDropIsUsed() {

        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.clickOnBoard("My First Board");

        boardsPage.moveCardToList();
    }

    @Test
    public void deleteBoardWhenDeleteButtonIsClicked() {

        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.clickOnBoard("My First Board");
        boardsPage.deleteBoard();

    }
}
