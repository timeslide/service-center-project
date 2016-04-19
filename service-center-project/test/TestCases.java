import org.junit.Test;

import com.garage.beans.User;
import com.garage.dao.RepairJobDAO;

public class TestCases {
	
  private User user;
  private RepairJobDAO repairJobDAO;	 
  public TestCases() {
    user = new User();
    repairJobDAO = new RepairJobDAO();
  }	
  
  
 @Test
 public void testValidUser() {
     assert user.validateUser("manager", "manager");
 }
 @Test
 public void testInValidUser() {
     assert !user.validateUser("manager", "wrongpassword");
 }
  @Test
  public void testaddNewPendingRepairJob() {
      assert repairJobDAO.addNewPendingRepairJob("Ford,", "New Exhust", "FR-3030"); 
  }
  @Test
  public void testUpdateJobStatus () {
      assert repairJobDAO.updateJobStatus(0,"Completed"); 
  }
 
}
