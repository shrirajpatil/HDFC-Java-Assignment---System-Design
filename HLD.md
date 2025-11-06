# 🎬 BookMyShow Clone — High-Level Design (HLD)

## 1. Overview
BookMyShowClone is a **web-based movie ticketing platform** that allows users to browse movies, view showtimes, select seats, and book tickets online.  
The system is designed for **scalability**, **high availability**, and **data durability**.

---

## 2. Functional Requirements
- User registration and login  
- Browse movies by city, theater, and date  
- View showtimes for a movie in a selected theater  
- Select seats from available ones  
- Book tickets and receive confirmation  

---

## 3. Non-Functional Requirements
| Requirement | Specification |
|--------------|---------------|
| Concurrent Users | ≥ 1000 |
| Availability | 99.9% |
| Latency (Browse/Search) | < 500ms |
| Data Durability | Booking data must not be lost |

---

## 4. Architecture Diagram
```
[Browser]
    |
[Load Balancer]
    |
[Web/App Servers]
    |
[Database] <-> [Cache]
```

### Components
- Authentication Service  
- Movie Catalog Service  
- Booking Service  
- Payment Service (mocked)

---

## 5. Major Components
| Component | Description |
|------------|--------------|
| **Authentication Service** | Handles user registration and login |
| **Movie Catalog Service** | Manages movies, theaters, and shows |
| **Booking Service** | Handles seat selection and booking logic |
| **Payment Service** | Mocked service, returns payment success |

---

## 6. Data Flow for Core Use Cases

### 6.1 User Searching for Movies
```
User logs in
↓
User selects city/date
↓
System fetches movies and shows for city/date
↓
User views available movies and showtimes
```

### 6.2 User Booking a Ticket
```
User selects movie, show, and seats
↓
System checks seat availability
↓
User confirms booking and (mock) payment
↓
System updates seat status and creates booking
↓
User receives booking confirmation
```

---

## 7. Key APIs
| Method | Endpoint | Description |
|---------|-----------|-------------|
| POST | `/users/register` | Register new user |
| POST | `/users/login` | Login |
| GET | `/movies?city=xyz` | List movies in a city |
| GET | `/shows?movieId=123&theaterId=456` | List showtimes |
| GET | `/shows/{id}/seats` | View available seats |
| POST | `/bookings` | Book selected seats |

---

## 8. Database Design (Summary)
| Table | Fields |
|--------|---------|
| **User** | user_id, name, email, password_hash, created_at |
| **Movie** | movie_id, title, language, genre, duration |
| **Theater** | theater_id, name, city |
| **Show** | show_id, movie_id, theater_id, show_time, screen_no |
| **Seat** | seat_id, show_id, seat_number, status |
| **Booking** | booking_id, user_id, show_id, seat_id, status, booking_time |

---

## 9. Security
- Passwords hashed using **BCrypt**  
- Basic authentication with **Spring Security**

---

## 10. Transaction Management
- All booking operations are **transactional**  
- Ensures **seat availability** and prevents **double booking**

---

## 11. Extensibility
- Modular **service/repository** structure  
- Easy to add new features such as:
  - Payments  
  - Notifications  
  - Loyalty Programs  
