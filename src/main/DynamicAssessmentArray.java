/*
    Programming for Computer Scientists (CS118) - Lab 5
    Classes and objects
*/

package lab5;

/**
* Represents a dynamic array for Assessment objects.
*/
public class DynamicAssessmentArray {
    /**
    * The underlying array.
    */
    private Assessment[] array;
    private int freePos = 0;
    private int resizeScale = 10;

    /**
    * Initialises a new dynamic array with the specified initial capacity.
    */
    public DynamicAssessmentArray(int initialCapacity) {
        this.array = new Assessment[initialCapacity];
    }

    /**
    * Gets the number of elements stored in this dynamic array.
    */
    public int getSize() {
        return this.freePos;
    }

    /**
    * Gets the current capacity of this dynamic array.
    */
    public int getCapacity() {
        return this.array.length;
    }

    /**
    * Increases the size of the underlying array by initialising a new array
    * and copies all elements from the old array into the new one.
    */
    private void resize() {
        Assessment[] newArray = new Assessment[getCapacity() + resizeScale];
        for (int i=0;i<getCapacity(); i++) {
          newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    /**
    * Adds a new element to this dynamic array.
    */
    public void add(Assessment assessment) {
        this.array[this.freePos] = assessment;
        this.freePos++;
        if (this.freePos == getCapacity())
          resize();
    }

    /**
    * Gets the element at the specified index. If the index is out of bounds,
    * this method returns null.
    */
    public Assessment get(int index) {
        return this.array[index];
    }


    //Sets number of elments added during resizing
    public void SetResizeScale(int resizeScale) {
      this.resizeScale = resizeScale;
    }
}
