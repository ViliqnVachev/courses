﻿namespace LogNoziroh.Controllers
{
    using Microsoft.AspNetCore.Mvc;
    using Models;
    using System.Linq;

    public class ReportController : Controller
    {
        private readonly LogNozirohDbContext dbContext;

        public ReportController(LogNozirohDbContext dbContext)
        {
            this.dbContext = dbContext;
        }

        [HttpGet]
        [Route("")]
        public IActionResult Index()
        {
            var report = dbContext.Reports.ToList();

            return View(report);
        }

        [HttpGet]
        [Route("details/{id}")]
        public IActionResult Details(int id)
        {
            var report = dbContext
                .Reports
                .Where(r => r.Id == id)
                .FirstOrDefault();

            return View(report);
        }

        [HttpGet]
        [Route("create")]
        public IActionResult Create()
        {
            return View();
        }

        [HttpPost]
        [Route("create")]
        [ValidateAntiForgeryToken]
        public IActionResult Create(Report report)
        {
            dbContext.Reports.Add(report);
            dbContext.SaveChanges();

            return RedirectToAction(nameof(Index));
        }

        [HttpGet]
        [Route("delete/{id}")]
        public IActionResult Delete(int id)
        {
            var report = dbContext
               .Reports
               .Where(r => r.Id == id)
               .FirstOrDefault();

            return View(report);
        }

        [HttpPost]
        [Route("delete/{id}")]
        [ValidateAntiForgeryToken]
        public IActionResult DeleteConfirm(int id, Report reportModel)
        {
            var report = dbContext
              .Reports
              .Where(r => r.Id == id)
              .FirstOrDefault();

            dbContext.Remove(report);
            dbContext.SaveChanges();
            return RedirectToAction(nameof(Index));
        }
    }
}
