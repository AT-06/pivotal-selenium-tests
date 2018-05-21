package org.fundacionjala.pivotal.objects.story;

import org.fundacionjala.pivotal.common.Base;
import org.fundacionjala.pivotal.common.CommonMethods;
import org.fundacionjala.pivotal.common.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.EnumMap;
import java.util.Map;

/**
 * This class represent the Story page.
 */
public class Story extends Base {

    @FindBy(how = How.CLASS_NAME, using = "Sidebar__addStoryText___3hNs8EcO")
    private WebElement buttonCreateStory;

    @FindBy(how = How.CSS, using = ".autosaves.save")
    private WebElement buttonSaveStory;

    @FindBy(how = How.CSS, using = "[class='expander undraggable']")
    private WebElement expanderStory;

    @FindBy(how = How.NAME, using = "story[name]")
    private WebElement txtStoryName;

    @FindBy(how = How.CSS, using = "div.type.row a.arrow.target")
    private WebElement dropdownStoryType;
    //setFormatStoryType click
    @FindBy(how = How.CSS, using = "[data-aid='renderedDescription']")
    private WebElement enableDescriptionText;

    @FindBy(how = How.CSS, using = "[data-aid='textarea']")
    private WebElement txtStoryDescription;

    @FindBy(how = How.CSS,
            using = "[class='SMkCk__Button QbMBD__Button--primary _3olWk__Button--small button__save___2XVnhUJI']")
    private WebElement buttonAddDescription;

    @FindBy(how = How.CSS, using = "[placeholder='Add a comment or paste an image']")
    private WebElement txtActivityComment;

    @FindBy(how = How.CSS, using = ".CommentEdit__button-group___2ytpiQPa button[type=\"button\"]")
    private WebElement buttonPostComment;

    @FindBy(how = How.CSS, using = "[data-aid='LabelsSearch__input']")
    private WebElement txtLabel;

    @FindBy(how = How.CSS, using = "[data-aid='BlockerAdd']")
    private WebElement enableBlocker;

    @FindBy(how = How.ID, using = "blocker-edit-new")
    private WebElement txtBlocker;

    @FindBy(how = How.CSS, using = "[data-aid='BlockerEdit__addButton']")
    private WebElement buttonAddBlocker;

    @FindBy(how = How.CSS, using = ".story:first-child .tracker_markup")
    private WebElement getStoryCreated;

    //DELETE
    @FindBy(how = How.CSS, using = ".autosaves.delete.hoverable.right_endcap")
    private WebElement buttonDeleteStory;
    @FindBy(how = How.CSS, using = "[class='SMkCk__Button SSqkh__Button--warning']")
    private WebElement buttonConfirmDelete;
    @FindBy(how = How.CSS,
            using = "li[class='tn_flash_message tn_flash_flash tn_expiring_flash tn_sliding_list_item "
                    + "tn_sliding_list_fade-enter tn_sliding_list_fade-enter-active']")
    private WebElement getDeleteMessage;
    //EDIT
    @FindBy(how = How.CSS, using = ".autosaves.close")
    private WebElement buttonCloseEdit;

    /**
     * Method to delete a story.
     */
    public void deleteStory() {
        CommonMethods.clickWebElement(expanderStory);
        CommonMethods.clickWebElement(buttonDeleteStory);
        CommonMethods.clickWebElement(buttonConfirmDelete);
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
        CommonMethods.waitWebElement(getStoryCreated);
        return getStoryCreated.getText();
    }

    /**
     * Method to click expander story button.
     */
    public void clickSToryExpander() {
        CommonMethods.clickWebElement(expanderStory);
    }

    /**
     * Method for set Story type.
     *
     * @param storyType String.
     */
    public void setStoryType(final String storyType) {
        CommonMethods.clickWebElement(dropdownStoryType);
        CommonMethods.clickWebElement(driver.findElement(By.className(
                String.format("%s%s%s", "item_", storyType, " "))));

    }

    /**
     * Method to click create story button.
     */
    public void setButtonCreateStory() {
        CommonMethods.clickWebElement(buttonCreateStory);
    }

    /**
     * Method for set Story name.
     *
     * @param storyName String.
     */
    public void setStoryName(final String storyName) {
        CommonMethods.setWebElement(txtStoryName, storyName);
    }

    /**
     * Method to select save story button.
     */
    public void setButtonSaveStory() {
        CommonMethods.clickWebElement(buttonSaveStory);
    }

    /**
     * Method for set a story description.
     *
     * @param storyDescription story description.
     */
    private void setStoryDescription(final String storyDescription) {
        CommonMethods.clickWebElement(enableDescriptionText);
        CommonMethods.setWebElement(txtStoryDescription, storyDescription);
        CommonMethods.clickWebElement(buttonAddDescription);
    }

    /**
     * Method for set a story comment.
     *
     * @param storyComment story comment.
     */
    public void setStoryComment(final String storyComment) {
        CommonMethods.setWebElement(txtActivityComment, storyComment);
        CommonMethods.clickWebElement(buttonPostComment);
    }

    /**
     * Method for set a story label.
     *
     * @param storyLabel label name.
     */
    public void setStoryLabel(final String storyLabel) {
        CommonMethods.setWebElement(txtLabel, storyLabel);
        CommonMethods.pressEnter(txtLabel);
    }

    /**
     * Method for set a story blocker.
     *
     * @param storyBlocker blocker.
     */
    public void setStoryBlocker(final String storyBlocker) {
        CommonMethods.clickWebElement(enableBlocker);
        CommonMethods.setWebElement(txtBlocker, storyBlocker);
        CommonMethods.clickWebElement(buttonAddBlocker);
    }

    /**
     * Method to select close edit button.
     */
    public void setButtonCloseEdit() {
        CommonMethods.clickWebElement(buttonCloseEdit);
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

