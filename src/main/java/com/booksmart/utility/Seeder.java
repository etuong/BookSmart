package com.booksmart.utility;

import com.booksmart.entity.Book;
import com.booksmart.entity.Role;
import com.booksmart.entity.User;
import com.booksmart.service.BookService;
import com.booksmart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Seeder {
    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    public void seedUsers() {
        User user = User.builder().username("q").password("q").email("noreply@gmail.com").build();
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setId(1L);
        role.setName("ROLE_USER");
        roles.add(role);

        userService.createUser(user, roles);
    }

    public void seedBooks() {
        bookService.save(Book.builder()
                .id(1L)
                .author("Avni Doshi")
                .description("In her youth, Tara was wild. She abandoned her arranged marriage to join an ashram, took a hapless artist for a lover, rebelled against every social expectation of a good Indian woman - all with her young child in tow. Years on, she is an old woman with a fading memory, mixing up her maid's wages and leaving the gas on all night, and her grown-up daughter is faced with the task of caring for a mother who never seemed to care for her.")
                .isbn(9780241441510L)
                .listPrice(9.99)
                .ourPrice(6.99)
                .title("Burnt Sugar")
                .publisher("Penguin Books Ltd")
                .build());

        bookService.save(Book.builder()
                .id(2L)
                .author("Tsitsi Dangarembga")
                .description("Here we meet Tambudzai, living in a run-down youth hostel in downtown Harare and anxious about her prospects after leaving a stagnant job. At every turn in her attempt to make a life for herself, she is faced with a fresh humiliation, until the painful contrast between the future she imagined and her daily reality ultimately drives her to a breaking point.")
                .isbn(9780571355518L)
                .listPrice(10.50)
                .ourPrice(8.99)
                .title("This Mournable Body")
                .publisher("FABER & FABER")
                .build());

        bookService.save(Book.builder()
                .id(3L)
                .author("Douglas Stuart")
                .description("Shuggie is different. Fastidious and fussy, he shares his mother's sense of snobbish propriety. The miners' children pick on him and adults condemn him as no' right. But Shuggie believes that if he tries his hardest, he can be normal like the other boys and help his mother escape this hopeless place.")
                .isbn(9781529019278L)
                .listPrice(12.99)
                .ourPrice(7.99)
                .title("Shuggie Bain")
                .publisher("Pan MacMillan")
                .build());

        bookService.save(Book.builder()
                .id(4L)
                .author("Delia Owens")
                .description("For years, rumors of the 'Marsh Girl' have haunted Barkley Cove, a quiet town on the North Carolina coast. So in late 1969, when handsome Chase Andrews is found dead, the locals immediately suspect Kya Clark, the so-called Marsh Girl. But Kya is not what they say. Sensitive and intelligent, she has survived for years alone in the marsh that she calls home, finding friends in the gulls and lessons in the sand. Then the time comes when she yearns to be touched and loved. When two young men from town become intrigued by her wild beauty, Kya opens herself to a new life - until the unthinkable happens.")
                .isbn(9781472154668L)
                .listPrice(15.99)
                .ourPrice(9.99)
                .title("Where the Crawdads Sing")
                .publisher("Little, Brown Book Group")
                .build());

        bookService.save(Book.builder()
                .id(5L)
                .author("President Barack Obama")
                .description("In the stirring, highly anticipated first volume of his presidential memoirs, Barack Obama tells the story of his improbable odyssey from young man searching for his identity to leader of the free world, describing in strikingly personal detail both his political education and the landmark moments of the first term of his historic presidency-a time of dramatic transformation and turmoil.")
                .isbn(9780241491515L)
                .listPrice(15.99)
                .ourPrice(12.99)
                .title("A Promised Land")
                .publisher("PENGUIN")
                .build());

        bookService.save(Book.builder()
                .id(6L)
                .author("Jordan B. Peterson")
                .description("In 12 Rules for Life, acclaimed public thinker and clinical psychologist Jordan B. Peterson offered an antidote to the chaos in our lives: eternal truths applied to modern anxieties. His insights have helped millions of readers and resonated powerfully around the world.")
                .isbn(9780241407622L)
                .listPrice(9.99)
                .ourPrice(5.99)
                .title("Beyond Order : 12 More Rules for Life")
                .publisher("Penguin Books Ltd")
                .build());

        bookService.save(Book.builder()
                .id(7L)
                .author("Chris Dickason")
                .description("Brain Games for Clever Kids is a fantastic bestselling puzzle book, brimming with memory, word and number workouts for the cleverest of kids!")
                .isbn(9781780552491L)
                .listPrice(7.50)
                .ourPrice(4.25)
                .title("Brain Games For Clever Kids")
                .publisher("Michael O'Mara Books Ltd")
                .build());

        bookService.save(Book.builder()
                .id(8L)
                .author("Ixta Belfrage")
                .description("In this stunning new cookbook Yotam and co-writer Ixta Belfrage break down the three factors that create flavour and offer innovative vegetable dishes that deliver brand-new ingredient combinations to excite and inspire.")
                .isbn(9781785038938L)
                .listPrice(12.69)
                .ourPrice(10.25)
                .title("Ottolenghi FLAVOUR")
                .publisher("Ebury Publishing")
                .build());

        bookService.save(Book.builder()
                .id(9L)
                .author("Gabriel Krauze")
                .description("This life is like being in an ocean. Some people keep swimming towards the bottom. Some people touch the bottom with one foot, or even both, and then push themselves off it to get back up to the top, where you can breathe. Others get to the bottom and decide they want to stay there. I don't want to get to the bottom because I'm already drowning.")
                .isbn(9780008374990L)
                .listPrice(5.99)
                .ourPrice(1.99)
                .title("Who They Was")
                .publisher("HarperCollins Publishers")
                .build());

        bookService.save(Book.builder()
                .id(10L)
                .author("Jojo Moyes")
                .description("Alice Wright doesn't love her new American husband. Nor her domineering father-in-law or the judgmental townsfolk of Baileyville, Kentucky. Stifled and misunderstood, she yearns for escape and finds it in defiant Margery O'Hare and the sisterhood bringing books to the isolated and vulnerable.")
                .isbn(9780718183219L)
                .listPrice(9.99)
                .ourPrice(9.99)
                .title("The Giver of Stars")
                .publisher("asd")
                .build());

//        bookService.save(Book.builder()
//                .author("sdf")
//                .description("asd")
//                .isbn(1111)
//                .listPrice(9.99)
//                .ourPrice(9.99)
//                .title("asd")
//                .publisher("asd")
//                .build());

    }
}
