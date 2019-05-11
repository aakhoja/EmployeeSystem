
public class FA2017LAB3_UnsortedOptimizedArray_Khoja
{   private int next;
    private int size;
    private FA2017LAB3_Employee_Khoja[ ] data;

    public FA2017LAB3_UnsortedOptimizedArray_Khoja(int size)
    {  next = 0;
        this.size = size;
        data = new FA2017LAB3_Employee_Khoja[size];
     }//end of constructor

     public boolean insert(FA2017LAB3_Employee_Khoja newNode)
     {  if(next >= size)  // the structure is full
            return false;
         data[next]= newNode.deepCopy( );  // store a deep copy of the client�s node
         if(data[next] == null) // insufficient system memory
            return false;
         next = next + 1; // prepare for the next insert
         return true;
     }// end of insert method

     public FA2017LAB3_Employee_Khoja fetch(String targetKey)
     {  FA2017LAB3_Employee_Khoja node;
     FA2017LAB3_Employee_Khoja temp;
       // access the node using a sequential search
         int i = 0;
         while ( i < next && !(data[i].compareTo(targetKey) == 0))
         {  
        	 i++;
         }
       if(i== next) // node not found
           return null;
       //deep copy the node's information into the client's node
          node = data[i].deepCopy( );
       // move the node up one position in the array, unless it is the first node
          if(i != 0) // bubble-up accessed node
         {   temp = data[i-1];
              data[i-1] = data[i];
              data[i] = temp;
         }
         return node;
     } // end of fetch method

     public boolean delete(String targetKey)
     {// access the node using a sequential search
         int i = 0;
         while (i < next && !(data[i].compareTo(targetKey) == 0))
         {   i++;
         }
         if(i == next) // node not found
             return false;
         //move the last node into the deleted node's position
          data[ i] = data[ next -1];
          data[next-1] = null;
          next = next - 1;
          return true; // node found and deleted
     }//end of the delete method

      public boolean update(String targetKey, FA2017LAB3_Employee_Khoja newNode)
     {  if(delete(targetKey) == false)  // node not in the structure
             return false;
         else if( insert(newNode ) == false)  // insufficient memory
             return false;
         else
             return true;  // node found and updated
      }// end of update method
      
      public void showAll(){
    	  for(int i = 0; i < next; i++)
    		  System.out.print(data[i].toString());
      }
   }//end of class UnsortedOptimizedArray

