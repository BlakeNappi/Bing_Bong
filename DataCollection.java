/**
 * @author Blake C. Nappi
 */

import java.awt.Graphics;


public interface DataCollection {
	
	// This interface allows items to be added
	  //    and removed from a collection of items.
	  // It also allows traversing the collection one item at a time,
	  //    selecting each item in turn.
	  // This traversal defines an implicit ordering of the items in
	  //    the collection, imposed by the order in which the items
	  //    were added to the collection.

	    public void add(Ball someItem);
	      // Adds the given Item to the collection.
	      // That item becomes the item currently selected.

	    public void remove();
	      // Removes the selected item (if any).
	      // No item is selected any more.

	    public void reset();
	      // Sets the selected item to be at the "start"
	      //    of the collection (if not empty).

	    public void paint(Graphics pane);
	      // Paints all items in the collection
	      //    (including the selected item, if any).
	      // Items are painted from left to right
	      //    in the order in which they were added.


}
