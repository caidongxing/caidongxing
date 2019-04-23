package mongoTest;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoTest {

	public static void main(String[] args) {
		 try{   
		       // ���ӵ� mongodb ����
		       MongoClient mongo=new MongoClient("localhost", 27017);
		         // ���ӵ����ݿ�
		       MongoDatabase database = mongo.getDatabase("test");
		       System.out.println("Connect to database successfully");
		        MongoCollection<Document> collection = database.getCollection("test");
		        System.out.println("����ѡ��ɹ�");
		      //�����ĵ�  
		         /** 
		         * 1. �����ĵ� org.bson.Document ����Ϊkey-value�ĸ�ʽ 
		         * 2. �����ĵ�����List<Document> 
		         * 3. ���ĵ����ϲ������ݿ⼯���� mongoCollection.insertMany(List<Document>) ���뵥���ĵ������� mongoCollection.insertOne(Document) 
		         * */
		        Document document = new Document("title","MongoDB").
		        		append("description", "database").  
		                append("likes", 200).  
		                append("by", "Fly");   
		        ArrayList<Document> documents = new ArrayList<Document>();
		        documents.add(document);
		        collection.insertMany(documents);
		        System.out.println("�ĵ�����ɹ�");
		      //���������ĵ�  
		         /** 
		         * 1. ��ȡ������FindIterable<Document> 
		         * 2. ��ȡ�α�MongoCursor<Document> 
		         * 3. ͨ���α�������������ĵ����� 
		         * */  
		      //�����ĵ�   ���ĵ���likes=100���ĵ��޸�Ϊlikes=200
		        //collection.updateMany(Filters.eq("likes", 100), new Document("$set",new Document("likes",200)));  
		        //ɾ���ĵ�
		        //collection.deleteOne(Filters.eq("likes", 200));
		        FindIterable<Document> findIterable = collection.find();
		        MongoCursor<Document> mongoCursor = findIterable.iterator();
		        while (mongoCursor.hasNext()) {
					Document document2 = (Document) mongoCursor.next();
					System.out.println(document2);
				}
		      }catch(Exception e){
		        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		     }
		   }
	}


