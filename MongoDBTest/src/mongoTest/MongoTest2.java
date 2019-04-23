package mongoTest;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

/**
 * ʹ��java����Mongodb
 * 
 * @author 
 * 
 */
public class MongoTest2 {

	// ��ѯ�����е������ĵ�
	@Test
	public void test1() throws Exception {
		//����mongodb������
		MongoClient mongo = new MongoClient("localhost", 27017);
		//���ӵ����ݿ�
		MongoDatabase mongoDatabase = mongo.getDatabase("test");
		//��ȡ���ݿ��collection
		MongoCollection<Document> collection = mongoDatabase.getCollection("test");
		FindIterable<Document> findIterable = collection.find();
		MongoCursor<Document> mongoCursor = findIterable.iterator();
		while (mongoCursor.hasNext()) {
			Document document = (Document) mongoCursor.next();
			System.out.println(document);
		}
		mongo.close();
	}

	// ��������ɾ������
	@Test
	public void test2() throws UnknownHostException {
		//����mongodb������
		MongoClient mongo=new MongoClient("localhost", 27017);
		//���ӵ����ݿ�
		MongoDatabase mongoDatabase = mongo.getDatabase("test");
		//��ȡ���ݿ��collection
		MongoCollection<Document> collection = mongoDatabase.getCollection("test");
		collection.deleteOne(Filters.eq("likes",300));
		System.out.println("ɾ�����ݳɹ�");
		mongo.close();
	}
	
	//�򼯺��в����ĵ�
	@Test
	public void test3() throws Exception{

		//����mongodb������
		MongoClient mongo=new MongoClient("localhost", 27017);
		//���ӵ����ݿ�
		MongoDatabase mongoDatabase = mongo.getDatabase("kewail");
		//��ȡ���ݿ��collection
		for(int i=0;i<300000;i++) {
		MongoCollection<Document> collection = mongoDatabase.getCollection("mail_biz_storage_201903");
		 Document document = new Document("userId",Long.parseLong("1542883592117")).
	        		append("taskId", "201901141442357701").  
	                append("title", "caidx").
	                append("status", "delivered").
	                append("remark", "550-5.7.1 [45age is  reduce the amount of spam sent to Gmail, 550-5.7.1 this message has been blocked. Please visit 550-5.7.1 https://support.google.com/mail/?p=UnsolicitedMessageError 550 5.7.1 for more information. a185si12339355yba.65 - gsmtp :").
	                append("sendTime", new Date()).
	                append("tryCount", 1).
	                append("createTime", new Date()).
	                append("email", "caidongxing8888@126.com"); 
		ArrayList<Document> documents = new ArrayList<Document>();
		documents.add(document);
			collection.insertMany(documents);
		}
		System.out.println("成功");
		mongo.close();
	}
	
	//���¼����е��ĵ� 519f3d9d47845d93bb56a0e6
	@Test
	public void test4() throws Exception{
		//����mongodb������
		MongoClient mongo=new MongoClient("localhost", 27017);
		//���ӵ����ݿ�
		MongoDatabase mongoDatabase = mongo.getDatabase("test");
		//��ȡ���ݿ��collection
		MongoCollection<Document> collection = mongoDatabase.getCollection("test");
		
		//collection.updateMany(Filters.eq("by", "Fly"), new Document("$set",new Document("by","cai")));
		collection.updateMany(Filters.eq("likes",300), new Document("$set", new Document("by", "Fly")));
		System.out.println("�޸ĳɹ�");
		FindIterable<Document> findIterable = collection.find();
		MongoCursor<Document> mongoCursor = findIterable.iterator();
		while (mongoCursor.hasNext()) {
			Document document = (Document) mongoCursor.next();
			System.out.println(document);
		}
		mongo.close();
	}
}
