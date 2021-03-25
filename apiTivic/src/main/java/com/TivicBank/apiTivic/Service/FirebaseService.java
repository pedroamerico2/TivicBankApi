package com.TivicBank.apiTivic.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.TivicBank.apiTivic.Objects.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseService {
	public String saveUserDetails(User user) throws InterruptedException, ExecutionException{
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(user.getName()).set(user);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}
	public User getUserDetails(String name) throws InterruptedException, ExecutionException{
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection("users").document(name);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		
		DocumentSnapshot document = future.get();
		
		User user = null;
				
		if(document.exists()) {
			user = document.toObject(User.class);
			return user;
		}else {
			return null;
		}
	}
	public List<User> getAllUsers()throws InterruptedException, ExecutionException{
		Firestore dbFirestore = FirestoreClient.getFirestore();
		List<User> useList = new ArrayList<User>();
		CollectionReference user = dbFirestore.collection("users");
		ApiFuture<QuerySnapshot> querySnapshot = user.get();
		for(DocumentSnapshot doc:querySnapshot.get().getDocuments()) {
			User use = doc.toObject(User.class);
			useList.add(use);
		}
		return useList;
	}

	public String updateUserDetails(User user) throws InterruptedException, ExecutionException{
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(user.getName()).set(user);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}
	public String deleteUserDetails(String name) throws InterruptedException, ExecutionException{
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> writeResult = dbFirestore.collection("users").document(name).delete();
		return "document with ID "+name+ " has been deleted";
	}
}
