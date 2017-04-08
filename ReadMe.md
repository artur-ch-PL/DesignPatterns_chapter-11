#Proxy pattern
Provide a surrogate or placeholder for another object to control access to it.



In short
=
- A remote proxy manages interaction between a client and a remote object.
- A Virtual Proxy controls access to an object that is expensive to instantiate
- A protection proxy controls access to the methods of an object based on the caller
- Many other variants of the Proxy Pattern exist including caching proxies, synchronization proies, firewall proxies, copy-on-write proxies, etc.
- Proxy is structurally similar to Decorator, but the two differ in their purpose
- Java's built-in support for roxy can build a dynamic proxy class on demand and dispatch all calls on it to a handler of your choosing
- Like any wrapper, proxies will increase the number of classes and objects in yours designs


OO principle
=
- Encapsulate what varies (soliD)
- Favor composition over inheritance (solId)
- Program to interfaces, not implementations (soLid)
- Strive for loosely coupled designs between objects that interact
- Classes should be open for extensions but close for modification (sOlid)
- Depend on abstractions. Do not depend on concrete classes.  (soLid)
- Only talk to your friends (Demeter law)
- Do not call us, we will call you (hollywood principle)  
- A class should have only one reason to change (Solid)

Other Proxy-patterns realisations:
- firewall proxy (control access to a set of network resources, protecting the subject from "bad" clients)
- smart reference proxy (provides additional actions whenever a subject is referenced, such as counting the number of references to an object)
- caching proxy (temporary storage for results of operations that are expensive. IT can also allow multipleclients to share the results to reduce computation or network latency)
- synchronization proxy (provides safe access to a subject from multiple threads)
- complexity hiding proxy (hides the complexity of and control to a complex set of classes. This is sometimes called the Facade PRoxy for obvious reasons. The Complexity HIding Proxy differs from Facade Pattern in that the proxy controls access, while the Facade Pattern just provides an alternative interface)
- copy-on-write (control the copying of an object by deferring the copying of an object until it is required by a client. This is a variant of the Virtual Proxy
