
package cs544.blog.dao;

import cs544.blog.domain.Address;
public interface IAddressDao {
    public Address addAddress(Address address);
    public boolean deleteAddress(Address address);
    public Address updateAddress(Address address);
    public Address getAddress(int id);
   
}
