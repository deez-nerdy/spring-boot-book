package spring.bookstore.springbootintro.repository;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import spring.bookstore.springbootintro.exception.DataProcessingException;
import spring.bookstore.springbootintro.model.Book;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {
    private final SessionFactory sessionFactory;

    @Override
    public Book save(Book book) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(book);
            transaction.commit();
            return book;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't save book to DB: " + book, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<Book> getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.find(Book.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't find book with id: " + id, e);
        }
    }

    @Override
    public List<Book> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Book> query = session.createQuery("FROM Book", Book.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't return list of all Books", e);
        }
    }
}
