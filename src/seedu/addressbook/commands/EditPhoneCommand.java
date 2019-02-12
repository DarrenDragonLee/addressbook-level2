package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;


/**
 * Edits the phone number of a person identified using it's last displayed index from the address book.
 */
public class EditPhoneCommand extends Command {

    public static final String COMMAND_WORD = "editphone";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the phone number of the person identified by the index number used in the last person listing.\n"
            + "Parameters: INDEX NEW_PHONE_NUMBER\n"
            + "Example: " + COMMAND_WORD + " 1 91230123";

    public static final String MESSAGE_EDIT_PHONE_SUCCESS = "Edited Person: %1$s";


    public EditPhoneCommand(int targetVisibleIndex) {
        
        super(targetVisibleIndex);
    }


    @Override
    public CommandResult execute() {
        try {
            final ReadOnlyPerson target = getTargetPerson();
            //addressBook.removePerson(target);
            return new CommandResult(String.format(MESSAGE_EDIT_PHONE_SUCCESS, target));

        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        //} catch (PersonNotFoundException pnfe) {
            //return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        }
    }

}