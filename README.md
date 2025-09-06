# 🍽️ Restaurant Filter Page Project

This project implements a **Restaurant Filter Page** where users can browse restaurants and filter based on **cuisine, rating, location, and price range**.  
It uses **React** for frontend and **Spring Boot** for backend services.  

---

## 🛠️ Tech Stack

### Frontend
- React.js (with hooks & functional components)
- Axios (API calls)
- Tailwind CSS / Bootstrap (UI styling)

### Backend
- Spring Boot (Java)
- Spring Web & Spring Data JPA
- H2 Database / MySQL (for data persistence)
- Maven (build tool)

### Other Tools
- Postman (API testing)
- Git/GitHub (version control)
- VS Code / IntelliJ IDEA

---

## 🏗️ High-Level Design (HLD)

The system is designed with a **client-server architecture**:

    flowchart TD
        Client[React Frontend] -->|HTTP Requests| API[Spring Boot REST API]
        API --> DB[(Database)]

## 📂 Folder Structure (HLD)

    restaurant-filter/
    │── frontend/
    │    ├── src/
    │    │    ├── components/   # UI components (Filter, RestaurantCard, etc.)
    │    │    ├── pages/        # Pages (Home, FilterPage)
    │    │    ├── services/     # Axios API calls
    │    │    └── App.js
    │
    │── backend/
    │    ├── src/main/java/com/restaurant/
    │    │    ├── controller/   # REST controllers
    │    │    ├── model/        # Entity classes
    │    │    ├── repository/   # JPA Repositories
    │    │    ├── service/      # Service classes
    │    │    └── RestaurantFilterApplication.java
    │    └── pom.xml

# 🔧 API Design

    Filter Restaurants
    
    Endpoint: GET /api/restaurants/filter
    
    Query Parameters (optional):
    
    cuisine → Filter by cuisine type
    
    rating → Minimum rating
    
    location → City or area
    
    priceRange → Max price
    
    Response: List of restaurants matching filters

# ⚙️ Low-Level Design (LLD)

    Frontend:
    
    FilterComponent → UI for selecting cuisine, rating, location, price
    
    RestaurantCard → Displays restaurant info
    
    useEffect + Axios → Fetch filtered restaurants on filter change
    
    Backend:
    
    RestaurantController → REST API endpoint /api/restaurants/filter
    
    RestaurantService → Business logic to filter restaurants
    
    RestaurantRepository → JPA repository to query database
    
    Database:
    
    Table: restaurants
    
    Columns: id, name, cuisine, rating, location, price_range

  ✅ Testing

    Use Postman to test API endpoints:
    
    Send GET requests to /api/restaurants/filter with query parameters
    
    Verify filtered results
    
    Frontend testing:
    
    Select filters → check if displayed restaurants match backend response
