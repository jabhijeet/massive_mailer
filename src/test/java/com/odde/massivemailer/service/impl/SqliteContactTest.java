package com.odde.massivemailer.service.impl;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.odde.massivemailer.model.ContactPerson;

@RunWith(MockitoJUnitRunner.class)
public class SqliteContactTest {

	private SqliteContact sqliteContact;

	@Mock
	private PreparedStatement mockPreparedStatement;
	
	@Mock
	private Statement mockStatement;

	@Mock
	private Connection mockConnection;

	@Before
	public void setUp() throws SQLException, ClassNotFoundException {
		sqliteContact = new SqliteContact();
		when(mockPreparedStatement.executeUpdate()).thenReturn(1);
		when(mockConnection.prepareStatement(Matchers.anyString())).thenReturn(mockPreparedStatement);
		sqliteContact.setConnection(mockConnection);
		
		// for addContact test
		
	}
	
	@After
	public void tearDown() {
		sqliteContact.closeConnection();
	}
	
//	@Test
//	public void testAddContact() throws SQLException{
//		
//		ContactPerson contactPerson = new ContactPerson("terry",
//				"roof@gmail.com", "e");
//		sqliteContact.addContact(contactPerson);
//		
//		verify(mockStatement).executeUpdate("INSERT INTO mail(name,email,company) VALUES ('"
//				+ contactPerson.getName() + "', '" + contactPerson.getEmail() + "','" + contactPerson.getCompany() + "')");
//	}
	
	@Test
	public void testUpdateContact() throws SQLException{
		
		ContactPerson contactPerson = new ContactPerson("terry",
				"roof@gmail.com", "e");
		sqliteContact.updateContact(contactPerson);
		verify(mockPreparedStatement).executeUpdate();
	}
	
	@Test
	public void testUpdateContactWithCompany() throws SQLException{
		
		ContactPerson contactPerson = new ContactPerson("terry",
				"roof@gmail.com", "e", "myCompany");
		sqliteContact.updateContact(contactPerson);
		verify(mockPreparedStatement).executeUpdate();
	}

	
	@Test(expected = SQLException.class)
	public void testUpdateContactFailed() throws SQLException{
		when(mockPreparedStatement.executeUpdate()).thenThrow(new SQLException());
		ContactPerson contactPerson = new ContactPerson("terry",
				"roof@gmail.com", "e");
		sqliteContact.updateContact(contactPerson);
	}
	
	
	@Test(expected = SQLException.class)
	public void testUpdateContactWithCompanyFailed() throws SQLException{
		when(mockPreparedStatement.executeUpdate()).thenThrow(new SQLException());
		ContactPerson contactPerson = new ContactPerson("terry",
				"roof@gmail.com", "e", "myCompany");
		sqliteContact.updateContact(contactPerson);
	}

}
