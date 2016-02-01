
package cs544.blog.dao;

import cs544.blog.domain.Address;
import org.hibernate.SessionFactory;


public class AddressDao implements IAddressDao{   
    
    private SessionFactory sf;
    public AddressDao(SessionFactory sf){
        this.sf=sf;
    }
    @Override
    public Address addAddress(Address address) {
        sf.getCurrentSession().saveOrUpdate(address);
        return address;
    }

    @Override
    public boolean deleteAddress(Address address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Address updateAddress(Address address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Address getAddress(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
