package ca.vastier.depense.daos.impl;

import ca.vastier.depense.daos.ReceiptDao;
import ca.vastier.depense.web.dto.ReceiptDto;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
@Qualifier("mongo")
public class MongoReceiptDaoImpl implements ReceiptDao
{
	@Override
	public ReceiptDto createReceipt(final ReceiptDto receipt)
	{
		System.out.println("inside of " + this.getClass().getName());

		ReceiptDto result;
		try (MongoClient mongoClient = new MongoClient())
		{
			MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
			MongoCollection mongoCollection = mongoDatabase.getCollection("receipts");
			mongoCollection.insertOne(receipt);

			FindIterable findIterable = mongoCollection.find();
			System.out.println("Total receipts: " + mongoCollection.countDocuments());
			result =  (ReceiptDto) mongoCollection.find().iterator().next();
		}

		return result;
	}
}
