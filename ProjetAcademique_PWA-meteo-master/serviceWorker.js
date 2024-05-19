const staticCacheName = "cache-v1";
const assets = ["/", "/index.html"];



self.addEventListener("install", (e) => {
	e.waitUntil(
		caches.open(staticCacheName).then((cache) => {
			cache.addAll(assets);
		})
	);
});

self.addEventListener("fetch", (event) => {
	if (event.request.url.startsWith("chrome-extension://")) {
		// Ne pas mettre en cache les ressources provenant de l'extension Chrome
		return;
	}
	event.respondWith(
		caches.match(event.request).then(function (response) {
			if (response) {
				return response;
			}

			var fetchRequest = event.request.clone();

			return fetch(fetchRequest).then(function (response) {
				if (!response || response.status !== 200 || response.type !== "basic") {
					return response;
				}

				var responseToCache = response.clone();

				caches.open(staticCacheName).then(function (cache) {
					cache.put(event.request, responseToCache);
				});

				return response;
			});
		})
	);


});

self.addEventListener("activate", (e) => {
	e.waitUntil(
		caches.keys().then((keys) => {
			return Promise.all(
				keys
					.filter((key) => key !== staticCacheName)
					.map((key) => caches.delete(key))
			);
		})
			.then(() => {
				return self.skipWaiting(); // Force le passage à l'état "active"
			})
	);
});

// const staticCacheName = "cache-v1";
// const assets = ["/", "/index.html"];

// // ajout fichiers en cache
// self.addEventListener("install", (e) => {
// 	e.waitUntil(
// 		caches.open(staticCacheName).then((cache) => {
// 			cache.addAll(assets);
// 		})
// 	);
// });

// self.addEventListener("fetch", (event) => {
// 	event.respondWith(
// 		caches.match(event.request).then(function (response) {
// 			// Cache hit - return response
// 			if (response) {
// 				return response;
// 			}

// 			// IMPORTANT: Cloner la requête.
// 			// Une requete est un flux et est à consommation unique
// 			// Il est donc nécessaire de copier la requete pour pouvoir l'utiliser et la servir
// 			var fetchRequest = event.request.clone();

// 			return fetch(fetchRequest).then(function (response) {
// 				if (!response || response.status !== 200 || response.type !== "basic") {
// 					return response;
// 				}

// 				// IMPORTANT: Même constat qu'au dessus, mais pour la mettre en cache
// 				var responseToCache = response.clone();

// 				caches.open(staticCacheName).then(function (cache) {
// 					cache.put(event.request, responseToCache);
// 				});

// 				return response;
// 			});
// 		})
// 	);
// });

// // supprimer caches
// self.addEventListener("activate", (e) => {
// 	e.waitUntil(
// 		caches.keys().then((keys) => {
// 			return Promise.add(
// 				keys
// 					.filter((key) => key !== staticCacheName)
// 					.map((key) => caches.delete(key))
// 			);
// 		})
// 	);
// });

// self.addEventListener('activate', function (event) {

// 	var cacheWhitelist = [CACHE_NAME];

// 	event.waitUntil(
// 		// Check de toutes les clés de cache.
// 		caches.keys().then(function (cacheNames) {
// 			return Promise.all(
// 				cacheNames.map(function (cacheName) {
// 					if (cacheWhitelist.indexOf(cacheName) === -1) {
// 						return caches.delete(cacheName);
// 					}
// 				})
// 			);
// 		})
// 	);
// });

// self.addEventListener("activate", (e) => {
// 	// Supprimer le cache au bout d'une minute
// 	setTimeout(() => {
// 		caches.keys().then((cacheNames) => {
// 			cacheNames.forEach((cacheName) => {
// 				if (cacheName.startsWith("cache-") && cacheName !== staticCacheName) {
// 					caches.delete(cacheName);
// 				}
// 			});
// 		});
// 	}, 60000);
// });