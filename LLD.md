# Low-Level Design (LLD)

## Entities & Database Schema

### User
- user_id (PK)
- name
- email (unique)
- password_hash
- created_at

### Movie
- movie_id (PK)
- title
- language
- genre
- duration

### Theater
- theater_id (PK)
- name
- city

### Show
- show_id (PK)
- movie_id (FK)
- theater_id (FK)
- show_time
- screen_no

### Seat
- seat_id (PK)
- show_id (FK)
- seat_number
- status (AVAILABLE, BOOKED)

### Booking
- booking_id (PK)
- user_id (FK)
- show_id (FK)
- seat_id (FK)
- status (CONFIRMED, CANCELLED)
- booking_time

## API Contracts

- POST /users/register → create account
- POST /users/login → authenticate
- GET /movies?city=xyz → list movies
- GET /shows?movieId=123&theaterId=456 → list showtimes
- GET /shows/{id}/seats → view available seats
- POST /bookings → book selected seats

## Sequence Diagram (Seat Booking)
```
User → App → Booking Service → Seat availability check → Update DB → Return confirmation
```

## Concurrency Handling
- Prevent double booking using row-level locks or unique constraints on (show_id, seat_number, status=BOOKED).
- Use JPA @Transactional and database constraints to ensure atomicity.
# High-Level Design (HLD)

## Functional Requirements
- User registration/login
- Browse movies by city, theater, date
- View showtimes for a movie in a selected theater
- Select seats from available ones
- Book tickets and get confirmation

## Non-Functional Requirements
- Handle at least 1000 concurrent users
- Availability: 99.9%
- Latency for browsing/search: < 500ms
- Data durability: booking data must not be lost

## Architecture Diagram
```
Browsers
   |
Load Balancer
   |
Web/App Servers
   |
+-------------------------------+
| Authentication Service        |
| Movie Catalog Service         |
| Booking Service               |
| Payment Service (mocked)      |
+-------------------------------+
   |
Database / Cache (PostgreSQL, Redis)
```

## Data Flow
### 1. User Searching for Movies
User → Browser → App Server → Movie Catalog Service → DB → Return Movies

### 2. User Booking a Ticket
User → Browser → App Server → Booking Service → Seat Availability Check → Update DB → Return Confirmation

