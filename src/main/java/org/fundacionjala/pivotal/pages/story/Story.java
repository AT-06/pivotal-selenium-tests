package org.fundacionjala.pivotal.pages.story;

import org.fundacionjala.core.selenium.Base;
import org.fundacionjala.core.selenium.CommonWebActions;
import org.fundacionjala.pivotal.pages.common.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.EnumMap;
import java.util.Map;

/**
 * This class represent the Story page.
 */
public class Story extends Base {

    @FindBy(className = "Sidebar__addStoryText___3hNs8EcO")
    private WebElement buttonCreateStory;

    @FindBy(css = ".autosaves.save")
    private WebElement buttonSaveStory;

    @FindBy(css = "[class='expander undraggable']")
    private WebElement expanderStory;

    @FindBy(name = "story[name]")
    private WebElement txtStoryName;

    @FindBy(css = "div.type.row a.arrow.target")
    private WebElement dropdownStoryType;
    //setFormatStoryType click
    @FindBy(css = "[data-aid='renderedDescription']")
    private WebElement enableDescriptionText;

    @FindBy(css = "[data-aid='textarea']")
    private WebElement txtStoryDescription;

    @FindBy(css = "[class='SMkCk__Button QbMBD__Button--primary _3olWk__Button--small button__save___2XVnhUJI']")
    private WebElement buttonAddDescription;

    @FindBy(css = "[placeholder='Add a comment or paste an image']")
    private WebElement txtActivityComment;

    @FindBy(css = ".CommentEdit__button-group___2ytpiQPa button[type=\"button\"]")
    private WebElement buttonPostComment;

    @FindBy(css = "[data-aid='LabelsSearch__input']")
    private WebElement txtLabel;

    @FindBy(css = "[data-aid='BlockerAdd']")
    private WebElement enableBlocker;

    @FindBy(id = "blocker-edit-new")
    private WebElement txtBlocker;

    @FindBy(css = "[data-aid='BlockerEdit__addButton']")
    private WebElement buttonAddBlocker;

    @FindBy(css = ".story:first-child .tracker_markup")
    private WebElement getStoryCreated;

    //DELETE
    @FindBy(css = ".autosaves.delete.hoverable.right_endcap")
    private WebElement buttonDeleteStory;

    @FindBy(css = "[class='SMkCk__Button SSqkh__Button--warning']")
    private WebElement buttonConfirmDelete;

    @FindBy(css = "li[class='tn_flash_message tn_flash_flash tn_expiring_flash tn_sliding_list_item "
            + "tn_sliding_list_fade-enter tn_sliding_list_fade-enter-active']")
    private WebElement getDeleteMessage;
    //EDIT
    @FindBy(css = ".persistence .close")
    private WebElement buttonCloseEdit;

    /**
     * Method to delete a story.
     */
    public void deleteStory() {
        CommonWebActions.clickElement(expanderStory);
        CommonWebActions.clickElement(buttonDeleteStory);
        CommonWebActions.clickElement(buttonConfirmDelete);
    }

    /**
     * Method to verify if the delete message is displayed.
     *
     * @return if the delete message is displayed.
     */
    public boolean deleteMessageIsDisplayed() {
        return getDeleteMessage.isDisplayed();
    }

    /**
     * Method to return the story name.
     *
     * @return the story name
     */
    public String verifyStoryName() {
        CommonWebActions.waitWebElementVisible(getStoryCreated);
        return getStoryCreated.getText();
    }

    /**
     * Method to click expander story button.
     */
    public void clickSToryExpander() {
        CommonWebActions.clickElement(expanderStory);
    }

    /**
     * Method for set Story type.
     *
     * @param storyType String.
     */
    public void setStoryType(final String storyType) {
        CommonWebActions.clickElement(dropdownStoryType);
        CommonWebActions.clickElement(driver.findElement(By.className(
                String.format("%s%s%s", "item_", storyType, " "))));

    }

    /**
     * Method to click create story button.
     */
    public void setButtonCreateStory() {
        CommonWebActions.clickElement(buttonCreateStory);
    }

    /**
     * Method for set Story name.
     *
     * @param storyName String.
     */
    public void setStoryName(final String storyName) {
        txtStoryName.clear();
        CommonWebActions.setTextElement(txtStoryName, storyName);
    }

    /**
     * Method to select save story button.
     */
    public void setButtonSaveStory() {
        CommonWebActions.clickElement(buttonSaveStory);
    }

    /**
     * Method for set a story description.
     *
     * @param storyDescription story description.
     */
    private void setStoryDescription(final String storyDescription) {
        CommonWebActions.clickElement(enableDescriptionText);
        CommonWebActions.setTextElement(txtStoryDescription, storyDescription);
        CommonWebActions.clickElement(buttonAddDescription);
    }

    /**
     * Method for set a story comment.
     *
     * @param storyComment story comment.
     */
    public void setStoryComment(final String storyComment) {
        CommonWebActions.setTextElement(txtActivityComment, storyComment);
        CommonWebActions.clickElement(buttonPostComment);
    }

    /**
     * Method for set a story label.
     *
     * @param storyLabel label name.
     */
    public void setStoryLabel(final String storyLabel) {
        CommonWebActions.setTextElement(txtLabel, storyLabel);
        CommonWebActions.pressEnter(txtLabel);
    }

    /**
     * Method for set a story blocker.
     *
     * @param storyBlocker blocker.
     */
    public void setStoryBlocker(final String storyBlocker) {
        CommonWebActions.clickElement(enableBlocker);
        CommonWebActions.setTextElement(txtBlocker, storyBlocker);
        CommonWebActions.clickElement(buttonAddBlocker);
    }

    /**
     * Method to select close edit button.
     */
    public void setButtonCloseEdit() {
        CommonWebActions.clickElement(buttonCloseEdit);
    }

    /**
     * Method for Strategy Step Map.
     *
     * @param values Map<DescriptionsStory, String>
     * @return strategyMap.
     */
    public final Map<DescriptionsStory, Steps> getStrategyStepMap(final Map<DescriptionsStory, String> values) {
        final EnumMap<DescriptionsStory, Steps> strategyMap = new EnumMap<>(DescriptionsStory.class);
        strategyMap.put(DescriptionsStory.STORY_NAME, () ->
                setStoryName(values.get(DescriptionsStory.STORY_NAME)));
        strategyMap.put(DescriptionsStory.STORY_TYPE, ()
                -> setStoryType(values.get(DescriptionsStory.STORY_TYPE)));
        strategyMap.put(DescriptionsStory.BLOCKERS, ()
                -> setStoryBlocker(values.get(DescriptionsStory.BLOCKERS)));
        strategyMap.put(DescriptionsStory.DESCRIPTION, ()
                -> setStoryDescription(values.get(DescriptionsStory.DESCRIPTION)));
        strategyMap.put(DescriptionsStory.LABEL, ()
                -> setStoryLabel(values.get(DescriptionsStory.LABEL)));
        strategyMap.put(DescriptionsStory.COMMENT, ()
                -> setStoryComment(values.get(DescriptionsStory.COMMENT)));
        return strategyMap;
    }
}
