package com.mystore.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.mystore.beans.ProductBean;
import com.mystore.beans.ProductCategoryBean;
import com.mystore.beans.SubCategoryBean;
import com.mystore.entities.User;
import com.mystore.util.HibernateUtil;

@Repository
public class HomeControllerDao {

	public List<ProductCategoryBean> loadHomePage(){
		Session session = null;
		List<ProductCategoryBean> productCategoryList = null;
		try{
			productCategoryList = new ArrayList<ProductCategoryBean>();
			List<SubCategoryBean> subCategoryList = null;
			List<ProductBean> productList = null;
			ProductCategoryBean productCategoryBean = null;
			SubCategoryBean subCategoryBean = null;
			ProductBean productBean = null;
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
	//		Query query = session.createSQLQuery(SQLConstant.GET_ALL_CATEGORIES.toString());
			Query query = session.createSQLQuery("SELECT * FROM productcategories");
			@SuppressWarnings("unchecked")
			List<Object> objCategoryList = query.list();
			for (int i = 0; i < objCategoryList.size(); i++) {
				productCategoryBean = new ProductCategoryBean();
				Object[] category = (Object[])objCategoryList.get(i);
				Integer productCaregoryId = (Integer)category[0];
				//System.out.println(category[1]);
				productCategoryBean.setCategoryID(productCaregoryId);
				productCategoryBean.setCategoryName(category[1].toString());
				
	//			Query subCategoryQuery = session.createSQLQuery(SQLConstant.FIND_SUBCATEGORY_BY_CATEGORY_ID.toString());
				Query subCategoryQuery = session.createSQLQuery("SELECT * FROM prod_subcategory WHERE productCategoryId = "+productCaregoryId);
	//			subCategoryQuery.setParameter(1, productCaregoryId);
				@SuppressWarnings("unchecked")
				List<Object> objSubcategoriesList = subCategoryQuery.list();
				subCategoryList = new ArrayList<SubCategoryBean>();
				for (int j = 0; j < objSubcategoriesList.size(); j++) {
					subCategoryBean = new SubCategoryBean();
					Object[] subCategory = (Object[])objSubcategoriesList.get(j);
					//System.out.println(subCategory[1]);
					Integer subCategoryId = (Integer)subCategory[0];
					subCategoryBean.setSubcategoryId(subCategoryId);
					subCategoryBean.setSubcategoryName(subCategory[1].toString());
					
	//				Query productQuery = session.createSQLQuery(SQLConstant.FIND_ALL_PRODUCTS_BY_SUBCATEGORY_ID.toString());
					Query productQuery = session.createSQLQuery("SELECT ProductID,ProductName,ProductOwner FROM products where ProductSubCategoryId = "+subCategoryId+" group by ProductOwner");
	//				productQuery.setParameter(1, subCategoryId);
					@SuppressWarnings("unchecked")
					List<Object> objProductList = productQuery.list();
					productList = new ArrayList<ProductBean>();
					for (int k = 0; k < objProductList.size(); k++) {
						productBean = new ProductBean();
						Object[] product = (Object[])objProductList.get(k);
						//System.out.println(product[1].toString());
						productBean.setProductID((Integer)product[0]);
						productBean.setProductName(product[1].toString());
						productBean.setProductOwner(product[2].toString());
						productList.add(productBean);
					}
					subCategoryBean.setProducts(productList);
					subCategoryList.add(subCategoryBean);
				}
				productCategoryBean.setProdSubcategories(subCategoryList);
				productCategoryList.add(productCategoryBean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.flush();
			session.clear();
			if(session.isOpen()){
				session.close();
			}
		}
		return productCategoryList;
	}
	
	public static void main(String[] args) {
//		HomeControllerDao controllerDao = new HomeControllerDao();
//		List<ProductCategoryBean> productCategory = controllerDao.loadHomePage();
	}

	public boolean signUp(User user) {
		SessionFactory sessionFactory = null;
		Session session = null;
		boolean status = false;
		try{
			sessionFactory = HibernateUtil.getSessionFactory();
			
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			user.setUserType(1);
			session.save(user);
			session.getTransaction().commit();
			status = true;
		}catch (Exception e) {
			e.printStackTrace();
			status = false;
		} finally{
			session.flush();
			if(session.isOpen()){
				session.close();
			}
			if(!sessionFactory.isClosed()){
				sessionFactory.close();
			}
		}
		return status;
	}
}
