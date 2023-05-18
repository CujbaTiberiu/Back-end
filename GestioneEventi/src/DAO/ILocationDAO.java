package DAO;

import java.util.List;

import entity.Location;

public interface ILocationDAO {

	public void save(Location e);
	public Location getById(int id);
	public void delete(Location e);
	public void update(Location e);
	public List<Location> getAll();
}
