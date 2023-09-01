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
        boardsPage.addNewList("To Do");
        boardsPage.addNewList("Doing");
        boardsPage.addNewList("Done");

        BoardPage boardPage = new BoardPage(actions.getDriver());

        boardPage.assertListExists("To Do");
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
