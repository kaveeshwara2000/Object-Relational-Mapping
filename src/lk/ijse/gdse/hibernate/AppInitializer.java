package lk.ijse.gdse.hibernate;


import lk.ijse.gdse.hibernate.embedded.MobileNo;
import lk.ijse.gdse.hibernate.embedded.NameIdentifier;
import lk.ijse.gdse.hibernate.entity.Customer;
import lk.ijse.gdse.hibernate.repository.CustomerRepository;
import lk.ijse.gdse.hibernate.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AppInitializer {
    public static void main(String[] args) {
        //save
        CustomerRepository customerRepository = new CustomerRepository();
        Customer customer=getCustomerEntity();
        customerRepository.saveCustomer(customer);

        //update
//        CustomerRepository customerRepository = new CustomerRepository();
//        Customer customer=customerRepository.getCustomer(1L);
//        System.out.println("Customer Id: "+customer.getId());
//
//        customer.setAddress("Matara");
//
//        boolean isUpdated = customerRepository.updateCustomer(customer);
//        if (isUpdated){
//            System.out.println("Customer "+customer.getId()+"Updated Sucessfully");
//        }else {
//            System.out.println("Customer "+customer.getId()+"Not Updated ");

        //Delete
//            CustomerRepository customerRepository = new CustomerRepository();
//        Customer customer=customerRepository.getCustomer(1L);
//        System.out.println("Customer Id: "+customer.getId());
//
//        customer.setAddress("Matara");
//
//        boolean isDelete = customerRepository.deleteCustomer(customer);
//        if (isDelete){
//            System.out.println("Customer "+customer.getId()+"Deleted Sucessfully");
//        }else {
//        System.out.println("Customer "+customer.getId()+"Not Deletted ");
//        }




//        customerRepository.saveCustomer();
//        Customer customer = new Customer();
//        customer.setId(1L);

        //set Embedded object Data
//        NameIdentifier custName = new NameIdentifier();
//        custName.setFirstName("Sachindu");
//        custName.setMiddleName("Kaveeshwara");
//        custName.setLastName("T.H");
//
//        customer.setName(custName);
//        customer.setAddress("Galle");
//        customer.setSalary(30000.00);
//
//        customer.setAge(22);
//
//        List<MobileNo> phoneNos  = new ArrayList<>();
//        phoneNos.add(new MobileNo("MOBILE","0760942677"));
//        phoneNos.add(new MobileNo("HOME","0412345678"));
//        customer.setPhoneNos(phoneNos);
//        Session session = SessionFactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        session.save(customer);
//
//        transaction.commit();
//        session.close();

    }
    private static Customer getCustomerEntity(){
        Customer customer = new Customer();
        customer.setId(1L);

        NameIdentifier nameIdentifier = new NameIdentifier();
        nameIdentifier.setFirstName("Sachindu");
        nameIdentifier.setMiddleName("Kaveeshwara");
        nameIdentifier.setLastName("T.H.");

        customer.setName(nameIdentifier);
        customer.setAddress("Galle");
        customer.setSalary(30000.00);

        customer.setAge(23);

        List<MobileNo> phoneNos  = new ArrayList<>();
        phoneNos.add(new MobileNo("MOBILE","0760942677"));
        phoneNos.add(new MobileNo("HOME","0412345678"));
        customer.setPhoneNos(phoneNos);
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);

        transaction.commit();
        session.close();

        return customer;
    }

}
